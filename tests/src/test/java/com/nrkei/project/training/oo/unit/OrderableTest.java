/*
 * Copyright (c) 2025 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.project.training.oo.unit;

import com.nrkei.project.training.oo.geometry.Rectangle;
import com.nrkei.project.training.oo.probability.Chance;
import org.junit.jupiter.api.Test;

import static com.nrkei.project.training.oo.order.Orderable.best;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Ensures Orderable interface works correctly
public final class OrderableTest {

    @Test void rectangleWithLargestArea() {
        assertEquals(24, best(
                new Rectangle(2, 3),
                new Rectangle(4, 6),
                Rectangle.square(3))
                .area());
    }

    @Test void leastLikelyChance() {
        assertEquals(new Chance(0.25), best(
                new Chance(0.5), new Chance(0.25), new Chance(0.75)
        ));
    }
}
