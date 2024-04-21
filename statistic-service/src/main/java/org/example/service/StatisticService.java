package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.api.model.Invoice;
import org.example.api.model.ParkingStatistic;
import org.example.model.StatisticDb;
import org.example.repository.StatisticRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class StatisticService {

    private final StatisticRepository statisticRepository;

    public List<ParkingStatistic> getStatistics() {
        return StreamSupport.stream(statisticRepository.findAll().spliterator(), false)
                            .map(statistic -> ParkingStatistic.builder()
                                                              .parkingName(statistic.getParkingName())
                                                              .currentCarsCount(statistic.getCurrentCarsCount())
                                                              .totalIncome(statistic.getTotalIncome())
                                                              .build())
                            .collect(Collectors.toList());
    }

    public ParkingStatistic getStatistic(String parkingName) {
        if (!statisticRepository.existsById(parkingName)) {
            throw new RuntimeException("Statistic for the parking does not exists.");
        }

        return statisticRepository.findById(parkingName)
                                  .map(statistic -> ParkingStatistic.builder()
                                                                    .parkingName(parkingName)
                                                                    .currentCarsCount(statistic.getCurrentCarsCount())
                                                                    .totalIncome(statistic.getTotalIncome())
                                                                    .build())
                                  .orElseThrow();
    }


    /**
     * Increases current number of cars on parking.
     *
     * @param parkingName - to that current number of cars will be increased
     */
    public void increaseCarsCount(String parkingName) {
        StatisticDb statistic = getStatisticForParking(parkingName);
        StatisticDb updatedStatistic = statistic.toBuilder()
                                                .currentCarsCount(statistic.getCurrentCarsCount() + 1)
                                                .build();

        statisticRepository.save(updatedStatistic);
    }

    /**
     * Decreases current number of cars on parking.
     *
     * @param parkingName - to that current number of cars will be decreased
     */
    public void decreaseCarsCount(String parkingName) {
        //TODO: implement
    }

    /**
     * Increases a total income for parking based on the data in the invoice.
     *
     * @param invoice - to get data from
     */
    public void increaseTotalIncome(Invoice invoice) {
        //TODO: implement
    }

    private StatisticDb getStatisticForParking(String parkingName) {
        if (!statisticRepository.existsById(parkingName)) {
            StatisticDb emptyStatistic = StatisticDb.builder()
                                                    .parkingName(parkingName)
                                                    .currentCarsCount(0)
                                                    .totalIncome(0)
                                                    .build();

            return statisticRepository.save(emptyStatistic);
        }

        return statisticRepository.findById(parkingName)
                                  .orElseThrow();
    }
}
