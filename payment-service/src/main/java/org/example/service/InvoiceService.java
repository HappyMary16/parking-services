package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.api.model.Car;
import org.example.api.model.Invoice;
import org.example.client.StatisticClient;
import org.example.model.InvoiceDb;
import org.example.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class InvoiceService {

    private final ParkingPriceService parkingPriceService;
    private final InvoiceRepository invoiceRepository;
    private final StatisticClient statisticClient;

    public List<Invoice> getInvoices() {
        return StreamSupport.stream(invoiceRepository.findAll().spliterator(), false)
                            .map(this::toInvoice)
                            .collect(Collectors.toList());
    }

    public List<Invoice> getInvoices(String parkingName) {
        return invoiceRepository.findAllByParkingName(parkingName)
                                .stream()
                                .map(this::toInvoice)
                                .collect(Collectors.toList());
    }

    public Invoice generateInvoice(String parkingName, Car car) {
        int pricePerHour = parkingPriceService.getPriceForParking(parkingName);

        Instant parkingStartTime = car.getParkingTime();
        Instant parkingEndTime = Instant.now();
        int durationMin = (int) Math.ceil((parkingEndTime.getEpochSecond() - parkingStartTime.getEpochSecond()) / 60d);
        float parkingPrice = durationMin * pricePerHour / 60f;

        // TODO:
        // generate invoice using info in the car
        // save invoice to DB and send it to statistic
        // service to update statistic
        // (you need just call the method like below)
        // statisticClient.updateTotalIncome(generatedInvoice);

        return null;
    }

    private Invoice toInvoice(InvoiceDb invoiceDb) {
        return Invoice.builder()
                      .id(invoiceDb.getId())
                      .parkingName(invoiceDb.getParkingName())
                      .carNumber(invoiceDb.getCarNumber())
                      .driverName(invoiceDb.getDriverName())
                      .parkingStartTime(invoiceDb.getParkingStartTime())
                      .parkingEndTime(invoiceDb.getParkingEndTime())
                      .price(invoiceDb.getPrice())
                      .build();
    }
}
