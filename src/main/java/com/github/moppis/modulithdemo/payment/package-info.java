@ApplicationModule(
        allowedDependencies = "order :: *"
)
@NullMarked
package com.github.moppis.modulithdemo.payment;

import org.jspecify.annotations.NullMarked;
import org.springframework.modulith.ApplicationModule;