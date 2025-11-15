package com.github.moppis.modulithdemo.payment;

import com.github.moppis.modulithdemo.order.internal.events.OrderCompleted;
import com.github.moppis.modulithdemo.order.internal.spi.OrderSPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentManagement {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentManagement.class);

    private final OrderSPI orderSPI;

    public PaymentManagement(OrderSPI orderSPI) {
        this.orderSPI = orderSPI;
    }

    @ApplicationModuleListener
    void on(OrderCompleted event) {
        var orderId = event.orderId();

        LOGGER.info("Received order completion for {}", orderId);

        orderSPI.busyWork();

        LOGGER.info("Finished order completion for {}", orderId);
    }
}
