@ApplicationModule(
        allowedDependencies = "order :: events"
)
@NullMarked
package com.github.moppis.modulithdemo.inventory;

import org.jspecify.annotations.NullMarked;
import org.springframework.modulith.ApplicationModule;