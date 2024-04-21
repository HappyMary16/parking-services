package org.example.client;

import org.example.api.model.Invoice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "statisticClient", url = "localhost:8083")
public interface StatisticClient {

    @PostMapping("/invoices")
    void updateTotalIncome(@RequestBody Invoice invoice);
}
