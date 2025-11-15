package com.github.moppis.modulithdemo.inventory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
class InventoryInternal {
    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryInternal.class);

    public void busyWork() {
        try {
            LOGGER.info("Work work!");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
