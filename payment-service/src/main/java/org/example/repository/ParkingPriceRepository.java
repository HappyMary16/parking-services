package org.example.repository;

import org.example.model.ParkingPriceDb;
import org.springframework.data.repository.CrudRepository;

public interface ParkingPriceRepository extends CrudRepository<ParkingPriceDb, String> {
}
