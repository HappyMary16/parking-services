package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.api.event.CarEvent;
import org.example.api.model.Car;
import org.example.api.model.Invoice;
import org.example.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/invoice")
@RestController
public class InvoiceController {

    private final InvoiceService invoiceService;

    /**
     * Generates an invoice when a car leaves a parking.
     *
     * @param parkingName - a parking name where a car was parked
     * @param car - info about a car
     * @return - a generated invoice
     */
    @PostMapping
    @RequestMapping("/{parkingName}")
    public Invoice generateInvoice(@PathVariable String parkingName, @RequestBody Car car) {
        return invoiceService.generateInvoice(parkingName, car);
    }

    @GetMapping
    public List<Invoice> getInvoices(@RequestParam(required = false) String parkingName) {
        if (parkingName == null) {
            return invoiceService.getInvoices();
        }
        return invoiceService.getInvoices(parkingName);
    }
}
