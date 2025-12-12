package com.github.moppis.modulithdemo.order.api.events;

import org.jmolecules.event.types.DomainEvent;

public record OrderCompleted(OrderIdentifier orderId) implements DomainEvent {
}
