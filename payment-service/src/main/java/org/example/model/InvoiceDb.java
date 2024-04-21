package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoices")
@Entity
public class InvoiceDb {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;
    private String carNumber;
    private String driverName;
    private String parkingName;
    private Instant parkingStartTime;
    private Instant parkingEndTime;
    private float price;
}
