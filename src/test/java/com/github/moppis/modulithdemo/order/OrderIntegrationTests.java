package com.github.moppis.modulithdemo.order;

import com.github.moppis.modulithdemo.order.internal.events.OrderCompleted;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

@ApplicationModuleTest
public class OrderIntegrationTests {

    private final OrderManagement orders;

    public OrderIntegrationTests(OrderManagement orders) {
        this.orders = orders;
    }

    @Test
    void publishesOrderCompletion(Scenario scenario) {
        var reference = new Order();

        scenario.stimulate(() -> orders.complete(reference))
                .andWaitForEventOfType(OrderCompleted.class)
                .matchingMappedValue(OrderCompleted::orderId, reference.getId())
                .toArrive();
    }
}
