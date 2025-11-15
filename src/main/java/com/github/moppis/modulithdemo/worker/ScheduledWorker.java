package com.github.moppis.modulithdemo.worker;

import com.github.moppis.modulithdemo.order.Order;
import com.github.moppis.modulithdemo.order.OrderManagement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledWorker {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledWorker.class);

    private final OrderManagement orderManagement;

    public ScheduledWorker(OrderManagement orderManagement) {
        this.orderManagement = orderManagement;
    }

    @Scheduled(cron = "*/30 * * * * *")
    public void completeOrder() {
        var order = new Order();
        LOGGER.info("Completing order: {}", order.getId());
        orderManagement.complete(order);
    }
}
