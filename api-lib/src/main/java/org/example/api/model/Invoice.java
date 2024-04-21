package org.example.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    private String id;
    private String carNumber;
    private String driverName;
    private String parkingName;
    private Instant parkingStartTime;
    private Instant parkingEndTime;
    private float price;
}
