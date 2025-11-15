package com.github.moppis.modulithdemo.order.internal.events;

import com.github.moppis.modulithdemo.order.OrderIdentifier;
import org.jmolecules.event.types.DomainEvent;

public record OrderCompleted(OrderIdentifier orderId) implements DomainEvent {}
