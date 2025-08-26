/*
 * Copyright (c) 2025 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.project.training.oo.order;

// Understands sequencing of elements
public interface Orderable<T> {
    boolean isBetterThan(T other);

    static <S extends Orderable<S>> S best(S first, S... elements) {
        if (elements.length == 0) return first;
        var champion = first;
        for (var challenger : elements) {
            if (challenger.isBetterThan(champion)) champion = challenger;
        }
        return champion;
    }
}
