package com.github.moppis.modulithdemo.payment.internal;

import com.github.moppis.modulithdemo.order.api.events.OrderCompleted;
import com.github.moppis.modulithdemo.order.api.events.OrderIdentifier;
import com.github.moppis.modulithdemo.payment.api.events.OrderNumber;
import com.github.moppis.modulithdemo.payment.api.events.PaymentProcessed;
import com.github.moppis.modulithdemo.payment.api.events.PaymentRejected;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

import java.awt.dnd.InvalidDnDOperationException;

@Service
public class PaymentManagement {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentManagement.class);

    private final ApplicationEventPublisher events;

    public PaymentManagement(ApplicationEventPublisher events) {
        this.events = events;
    }

    @ApplicationModuleListener
    void on(OrderCompleted event) {
        OrderIdentifier orderId = event.orderId();

        LOGGER.info("Received order completion for {} - will send to master card", orderId);

        LOGGER.info("Finished order completion for {}", orderId);

        if (orderId.id().toString().endsWith("5")) {
            throw new InvalidDnDOperationException("Simulated failure for order " + orderId);
        }
        if (orderId.id().toString().endsWith("2")) {
            LOGGER.info("Publishing custom event for order {}", orderId);
            var orderNumber = getOrderNumber(orderId);
            var processed = new PaymentProcessed(orderNumber);
            events.publishEvent(processed);
        } else {
            LOGGER.warn("Payment rejected for {}", orderId);
            var orderNumber = getOrderNumber(orderId);
            var rejected = new PaymentRejected(orderNumber, "KYC failure, order made by Pxxtin");
            events.publishEvent(rejected);

        }
    }

    private static @NonNull OrderNumber getOrderNumber(OrderIdentifier orderId) {
        return new OrderNumber(orderId.id().getLeastSignificantBits(), orderId.id().getMostSignificantBits());
    }
}
