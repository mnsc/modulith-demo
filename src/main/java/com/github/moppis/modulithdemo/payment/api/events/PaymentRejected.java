package com.github.moppis.modulithdemo.payment.api.events;

public record PaymentRejected(OrderNumber orderNumber, String reason) {
}
