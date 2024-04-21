package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.api.model.Invoice;
import org.example.service.StatisticService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/invoices")
@RestController
public class InvoiceController {

    private final StatisticService statisticService;

    @PostMapping
    public void processInvoice(@RequestBody Invoice invoice) {
        statisticService.increaseTotalIncome(invoice);
    }
}
