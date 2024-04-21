package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "statistics")
@Entity
public class StatisticDb {

    @Id
    private String parkingName;
    private int currentCarsCount;
    private float totalIncome;
}
