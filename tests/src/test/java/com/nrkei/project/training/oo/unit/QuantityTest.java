/*
 * Copyright (c) 2025 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.project.training.oo.unit;

import com.nrkei.project.training.oo.quantities.Quantity;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static com.nrkei.project.training.oo.quantities.Unit.*;
import static org.junit.jupiter.api.Assertions.*;

// Ensures Quantity operates correctly
public final class QuantityTest {


    @Test void equalityOfLikeUnits() {
        assertEquals(TABLESPOON.s(4), TABLESPOON.s(4));
        assertNotEquals(TABLESPOON.s(4), TABLESPOON.s(6));
        assertNotEquals(TABLESPOON.s(4), new Object());
        assertNotEquals(TABLESPOON.s(4), null);
    }

    @Test void equalityOfDifferentUnits() {
        assertNotEquals(TABLESPOON.s(4), TEASPOON.s(4));
    }

    @Test void setOperations() {
        assertTrue(new HashSet<>(Collections.singletonList(TABLESPOON.s(4))).contains(TABLESPOON.s(4)));
        assertEquals(1, new HashSet<>(Arrays.asList(TABLESPOON.s(4), TABLESPOON.s(4))).size());
    }

    @Test void hash() {
        assertEquals(TABLESPOON.s(4).hashCode(), TABLESPOON.s(4).hashCode());
    }
}
