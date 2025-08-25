/*
 * Copyright (c) 2025 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.project.training.oo.unit;

import com.nrkei.project.training.oo.geometry.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Ensures Rectangle works correctly
public class RectangleTest {

    @Test void area() {
        assertEquals(24.0, new Rectangle(4.0, 6.0).area());
        assertEquals(36, Rectangle.square(6.0).area());
    }

    @Test void perimeter() {
        assertEquals(20.0, new Rectangle(4.0, 6.0).perimeter());
        assertEquals(24, Rectangle.square(6.0).perimeter());
    }

    @Test void parameterRanges() {
        assertThrows(AssertionError.class, () -> new Rectangle(0, 6));
        assertThrows(AssertionError.class, () -> new Rectangle(4, 0));
        assertThrows(AssertionError.class, () -> Rectangle.square(0));
    }
}
