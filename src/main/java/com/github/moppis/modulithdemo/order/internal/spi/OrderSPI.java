package com.github.moppis.modulithdemo.order.internal.spi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OrderSPI {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderSPI.class);

    public void busyWork() {
        try {
            LOGGER.info("Work work!");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
