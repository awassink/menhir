package nl.awassink.menhir.order.exposed;

import org.jmolecules.event.types.DomainEvent;

public record OrderCreatedDto (Long orderID, Long amount) implements DomainEvent {
}
