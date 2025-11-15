package com.github.moppis.modulithdemo.order;

import com.github.moppis.modulithdemo.order.internal.OrderInternal;
import com.github.moppis.modulithdemo.order.internal.events.OrderCompleted;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderManagement {

    private final ApplicationEventPublisher events;
    private final OrderInternal orderInternal;

    public OrderManagement(ApplicationEventPublisher events, OrderInternal orderInternal) {
        this.events = events;
        this.orderInternal = orderInternal;
    }

    @Transactional
    public void complete(Order order) {
        orderInternal.busyWork();
        events.publishEvent(new OrderCompleted(order.getId()));
    }
}
