package com.github.moppis.modulithdemo.order;

import com.github.moppis.modulithdemo.order.internal.events.OrderCompleted;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.modulith.events.core.EventPublicationRegistry;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationModuleTest
@Import(EventPublicationRegistryTests.FailingAsyncTransactionalEventListener.class)
@DirtiesContext
public class EventPublicationRegistryTests {

    private final OrderManagement orders;
    private final EventPublicationRegistry registry;
    private final FailingAsyncTransactionalEventListener listener;

    public EventPublicationRegistryTests(OrderManagement orders, EventPublicationRegistry registry, FailingAsyncTransactionalEventListener listener) {
        this.orders = orders;
        this.registry = registry;
        this.listener = listener;
    }

    @Test
    void leavesPublicationIncompleteForFailingListener(Scenario scenario) {

        var order = new Order();

        scenario.stimulate(() -> orders.complete(order))
                .andWaitForStateChange(listener::getEx)
                .andVerify(_ -> assertThat(registry.findIncompletePublications()).hasSize(1));
    }

    static class FailingAsyncTransactionalEventListener {

        Exception ex;

        public Exception getEx() {
            return ex;
        }

        @ApplicationModuleListener
        void foo(OrderCompleted event) {
            var exception = new IllegalStateException("¯\\_(ツ)_/¯");

            try {
                throw exception;
            } finally {
                this.ex = exception;
            }
        }
    }
}
