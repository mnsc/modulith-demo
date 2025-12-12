package com.github.moppis.modulithdemo.order.api.events;

import jakarta.persistence.Embeddable;
import org.jmolecules.ddd.types.Identifier;

import java.util.UUID;

@Embeddable
public record OrderIdentifier(UUID id) implements Identifier {
}
