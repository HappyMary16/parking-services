package org.example.repository;

import org.example.model.InvoiceDb;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoiceRepository extends CrudRepository<InvoiceDb, String> {

    List<InvoiceDb> findAllByParkingName(String parkingName);
}
