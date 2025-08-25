/*
 * Copyright (c) 2025 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.project.training.oo.quantities;

import java.util.Objects;

// Understands a specific measurement
public final class Quantity {
    private final double amount;
    private final Unit unit;

    Quantity(double amount, Unit unit) {
        this.amount = amount;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj instanceof Quantity && this.equals((Quantity) obj);
    }

    private boolean equals(Quantity quantity) {
        return this.amount == quantity.amount && this.unit == quantity.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, unit);
    }
}
