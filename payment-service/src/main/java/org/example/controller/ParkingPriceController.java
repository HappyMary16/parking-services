package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.ParkingPriceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/parking/{parkingName}/price")
@RestController
public class ParkingPriceController {

    private final ParkingPriceService parkingPriceService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/{price}")
    public void saveParkingPrice(@PathVariable String parkingName,
                                 @PathVariable Integer price) {
        parkingPriceService.saveParkingPrice(parkingName, price);
    }
}
