/*
 * Copyright (c) 2025 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.project.training.oo.quantities;

import com.nrkei.project.training.oo.order.Orderable;

// Understands a specific measurement along a scale
public class IntervalQuantity implements Orderable<IntervalQuantity> {
    static double EPSILON = 1e-10;
    protected final double amount;
    protected final Unit unit;

    IntervalQuantity(double amount, Unit unit) {
        this.amount = amount;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj instanceof IntervalQuantity && this.equals((IntervalQuantity) obj);
    }

    private boolean equals(IntervalQuantity other) {
        return this.isCompatible(other) &&
                Math.abs(this.amount - convertedAmount(other)) < EPSILON;
    }

    private boolean isCompatible(IntervalQuantity other) {
        return this.unit.isCompatible(other.unit);
    }

    protected double convertedAmount(IntervalQuantity other) {
        return this.unit.convertedAmount(other.amount, other.unit);
    }

    @Override
    public int hashCode() {
        return unit.hashCode(amount);
    }

    @Override
    public boolean isBetterThan(IntervalQuantity other) {
        return this.amount > convertedAmount(other);
    }
}
