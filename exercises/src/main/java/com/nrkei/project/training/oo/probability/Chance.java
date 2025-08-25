/*
 * Copyright (c) 2025 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.project.training.oo.probability;

import java.util.Objects;

// Understands the likelihood of something specific occurring
public final class Chance {
    private static final double CERTAIN_FRACTION = 1.0;
    private static final double EPSILON = 1e-10;
    private final double fraction;

    public Chance(double likelihoodAsFraction) {
        this.fraction = likelihoodAsFraction;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj instanceof Chance && this.equals((Chance) obj);
    }

    private boolean equals(Chance chance) {
        return Math.abs(this.fraction - chance.fraction) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.round(fraction/EPSILON));
    }

    public Chance not() {
        return new Chance(CERTAIN_FRACTION - fraction);
    }

    public Chance and(Chance other) {
        return new Chance(this.fraction * other.fraction);
    }
}
