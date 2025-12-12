package com.github.moppis.modulithdemo.payment.internal;

import com.github.moppis.modulithdemo.order.internal.events.OrderCompleted;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentManagement {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentManagement.class);


    @ApplicationModuleListener
    void on(OrderCompleted event) {
        var orderId = event.orderId();

        LOGGER.info("Received order completion for {} - will send to master card", orderId);

        LOGGER.info("Finished order completion for {}", orderId);
    }
}
