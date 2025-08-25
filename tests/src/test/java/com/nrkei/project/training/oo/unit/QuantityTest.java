/*
 * Copyright (c) 2025 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.project.training.oo.unit;

import com.nrkei.project.training.oo.quantities.IntervalQuantity;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static com.nrkei.project.training.oo.quantities.Unit.*;
import static org.junit.jupiter.api.Assertions.*;

// Ensures Quantity operates correctly
public final class QuantityTest {

    @Test void equalityOfDifferentUnits() {
        assertNotEquals(TABLESPOON.s(4), TEASPOON.s(4));
        assertEquals(CUP.s(1/4.0), TABLESPOON.s(4));
        assertEquals(GALLON.s(1), TEASPOON.s(768));
        assertNotEquals(TABLESPOON.s(4), TEASPOON.s(4));
        assertEquals(MILE.s(1), INCH.es(12 * 5280));
    }

    @Test void setOperations() {
        assertTrue(new HashSet<>(Collections.singletonList(TABLESPOON.s(4))).contains(TABLESPOON.s(4)));
        assertTrue(new HashSet<>(Collections.singletonList(TABLESPOON.s(4))).contains(OUNCE.s(2)));
        assertEquals(1, new HashSet<>(Arrays.asList(TABLESPOON.s(4), TABLESPOON.s(4))).size());
        assertEquals(1, new HashSet<>(Arrays.asList(TABLESPOON.s(4), OUNCE.s(2))).size());
    }

    @Test void hash() {
        assertEquals(TABLESPOON.s(4).hashCode(), TABLESPOON.s(4).hashCode());
        assertEquals(TABLESPOON.s(4).hashCode(), CUP.s(1/4.0).hashCode());
        assertEquals(FAHRENHEIT.s(325).hashCode(), GAS_MARK.s(3).hashCode());
    }

    @Test void arithmetic() {
        assertEquals(QUART.s(0.5), TABLESPOON.s(6).plus(OUNCE.s(13)));
        assertEquals(TABLESPOON.s(-6), TABLESPOON.s(6).negate());
        assertEquals(PINT.s(-0.5), TABLESPOON.s(10).minus(OUNCE.s(13)));
        assertEquals(FOOT.s(-4), INCH.es(24).minus(YARD.s(2)));
    }

    @Test void crossMetricType() {
        assertNotEquals(INCH.es(1), TEASPOON.s(1));
        assertNotEquals(OUNCE.s(4), FOOT.s(2));
    }

    @Test void mixedUnitArithmetic() {
        assertThrows(AssertionError.class, () -> YARD.s(3).minus(TABLESPOON.s(4)));
    }

    @Test void temperature() {
        assertTemperatureSymmetry(CELSIUS.es(0), FAHRENHEIT.s(32));
        assertTemperatureSymmetry(CELSIUS.es(10), FAHRENHEIT.s(50));
        assertTemperatureSymmetry(CELSIUS.es(100), FAHRENHEIT.s(212));
        assertTemperatureSymmetry(CELSIUS.es(-40), FAHRENHEIT.s(-40));
        assertTemperatureSymmetry(FAHRENHEIT.s(325), GAS_MARK.s(3));
        assertTemperatureSymmetry(CELSIUS.es(0), KELVIN.s(273.15));
        assertTemperatureSymmetry(FAHRENHEIT.s(50), KELVIN.s(283.15));
        assertTemperatureSymmetry(FAHRENHEIT.s(50), RANKINE.s(509.67));
    }

    @Test void temperatureArithmetic() {
       // The following lines should not compile
//        CELSIUS.es(10).plus(FAHRENHEIT.s(50));
//        CELSIUS.es(10).negate();
    }

    private void assertTemperatureSymmetry(IntervalQuantity left, IntervalQuantity right) {
        assertEquals(left, right);
        assertEquals(right, left);
    }
}
