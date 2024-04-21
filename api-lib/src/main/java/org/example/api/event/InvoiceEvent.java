package org.example.api.event;

import lombok.*;
import org.example.api.model.Invoice;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class InvoiceEvent extends AbstractKafkaEvent {

    private Invoice invoice;

    @Builder
    public InvoiceEvent(EventAction eventAction, Invoice invoice) {
        super(eventAction);
        this.invoice = invoice;
    }
}
