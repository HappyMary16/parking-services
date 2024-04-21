package org.example.api.event;

import lombok.*;
import org.example.api.model.Car;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CarEvent extends AbstractKafkaEvent {

    private String parkingName;
    private Car car;

    @Builder
    public CarEvent(EventAction eventAction, String parkingName, Car car) {
        super(eventAction);
        this.parkingName = parkingName;
        this.car = car;
    }
}
