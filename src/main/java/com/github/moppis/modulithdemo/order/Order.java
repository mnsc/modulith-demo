package com.github.moppis.modulithdemo.order;

import org.jmolecules.ddd.types.AggregateRoot;

import java.util.UUID;

public class Order implements AggregateRoot<Order, OrderIdentifier> {
    private final OrderIdentifier id = new OrderIdentifier(UUID.randomUUID());

    @Override
    public OrderIdentifier getId() {
        return id;
    }
}

