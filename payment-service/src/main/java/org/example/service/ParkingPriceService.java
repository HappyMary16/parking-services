package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.ParkingPriceDb;
import org.example.repository.ParkingPriceRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ParkingPriceService {

    @Value("${parking.default-price.uah}")
    private int defaultPriceForHour;

    private final ParkingPriceRepository parkingPriceRepository;

    public int getPriceForParking(String parkingName) {
        if (!parkingPriceRepository.existsById(parkingName)) {
            return defaultPriceForHour;
        }

        return parkingPriceRepository.findById(parkingName)
                                     .map(ParkingPriceDb::getPricePerHour)
                                     .orElse(defaultPriceForHour);
    }

    public void saveParkingPrice(String parkingName, Integer priceForHour) {
        ParkingPriceDb parkingPrice = ParkingPriceDb.builder()
                                                    .parkingName(parkingName)
                                                    .pricePerHour(priceForHour)
                                                    .build();
        parkingPriceRepository.save(parkingPrice);
    }
}
