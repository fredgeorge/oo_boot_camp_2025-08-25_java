/*
 * Copyright (c) 2025 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.project.training.oo.unit;

import com.nrkei.project.training.oo.geometry.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Ensures Rectangle works correctly
public class RectangleTest {

    @Test void area() {
        assertEquals(24.0, new Rectangle(4.0, 6.0).area());
    }
}
