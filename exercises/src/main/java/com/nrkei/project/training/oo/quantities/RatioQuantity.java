/*
 * Copyright (c) 2025 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.project.training.oo.quantities;

// Understands a specific measurement
public final class RatioQuantity extends IntervalQuantity {

    RatioQuantity(double amount, Unit unit) {
        super(amount, unit);
    }

    public RatioQuantity plus(RatioQuantity other) {
        return new RatioQuantity(this.amount + convertedAmount(other), unit);
    }

    public RatioQuantity negate() {
        return new RatioQuantity(-this.amount, unit);
    }

    public RatioQuantity minus(RatioQuantity other) {
        return this.plus(other.negate());
    }
}
