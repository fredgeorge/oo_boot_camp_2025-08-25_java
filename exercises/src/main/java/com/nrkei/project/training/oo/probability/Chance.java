/*
 * Copyright (c) 2025 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.project.training.oo.probability;

import com.nrkei.project.training.oo.order.Orderable;

import java.util.Objects;

// Understands the likelihood of something specific occurring
public final class Chance implements Orderable<Chance> {
    private static final double CERTAIN_FRACTION = 1.0;
    private static final double EPSILON = 1e-10;
    private final double fraction;

    public Chance(double likelihoodAsFraction) {
        assert likelihoodAsFraction >= 0.0;
        assert likelihoodAsFraction <= CERTAIN_FRACTION;
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

    // Implemented with DeMorgan's Law https://en.wikipedia.org/wiki/De_Morgan%27s_laws
    public Chance or(Chance other) {
        return this.not().and(other.not()).not();
    }

    @Override
    public boolean isBetterThan(Chance other) {
        return this.fraction < other.fraction;
    }
}
