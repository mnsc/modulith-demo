package com.github.moppis.modulithdemo.inventory;

import com.github.moppis.modulithdemo.order.api.events.OrderCompleted;
import org.jmolecules.ddd.annotation.Service;
import org.springframework.modulith.events.ApplicationModuleListener;

@Service
public class InventoryManagement {

    private final InventoryInternal inventoryInternal;

    public InventoryManagement(InventoryInternal inventoryInternal) {
        this.inventoryInternal = inventoryInternal;
    }

    @ApplicationModuleListener
    void on(OrderCompleted event) {
        var orderId = event.orderId();

        System.out.println("Received order completion for " + orderId);

        inventoryInternal.busyWork();

        System.out.println("Finished order completion for " + orderId);
    }
}
