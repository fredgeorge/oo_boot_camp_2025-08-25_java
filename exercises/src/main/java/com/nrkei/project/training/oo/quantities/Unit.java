/*
 * Copyright (c) 2025 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.project.training.oo.quantities;

import java.util.Objects;

// Understands a specific metric
public final class Unit {
    public static final Unit TEASPOON = new Unit();
    public static final Unit TABLESPOON = new Unit(3, TEASPOON);
    public static final Unit OUNCE = new Unit(2, TABLESPOON);
    public static final Unit CUP = new Unit(8, OUNCE);
    public static final Unit PINT = new Unit(2, CUP);
    public static final Unit QUART = new Unit(2, PINT);
    public static final Unit GALLON = new Unit(4, QUART);

    public static final Unit INCH = new Unit();
    public static final Unit FOOT = new Unit(12, INCH);
    public static final Unit YARD = new Unit(3, FOOT);
    public static final Unit FATHOM = new Unit(6, FOOT);
    public static final Unit CHAIN = new Unit(22, YARD);
    public static final Unit FURLONG = new Unit(10, CHAIN);
    public static final Unit MILE = new Unit(8, FURLONG);
    public static final Unit LEAGUE = new Unit(3, MILE);

    public static final Unit CELSIUS = new Unit();
    public static final Unit FAHRENHEIT = new Unit(5/9.0, 32, CELSIUS);

    private final Unit baseUnit;
    private final double baseUnitRatio;
    private final double offset;

    private Unit() {
        baseUnit = this;
        baseUnitRatio = 1.0;
        offset = 0.0;
    }

    private Unit(double relativeRatio, double offset, Unit relativeUnit) {
        baseUnit = relativeUnit.baseUnit;
        baseUnitRatio = relativeRatio * relativeUnit.baseUnitRatio;
        this.offset = offset;
    }

    private Unit(double relativeRatio, Unit relativeUnit) {
        this(relativeRatio, 0.0, relativeUnit);
    }

    public Quantity s(double amount) {
        return new Quantity(amount, this);
    }

    public Quantity es(double amount) {
        return s(amount);
    }

    double convertedAmount(double otherAmount, Unit other) {
        assert this.isCompatible(other);
        return (otherAmount - other.offset) * other.baseUnitRatio / // Convert to base Unit
                this.baseUnitRatio + this.offset; // Convert from base Unit
    }

    int hashCode(double amount) {
        return Objects.hash((amount - offset) * baseUnitRatio);
    }

    boolean isCompatible(Unit other) {
        return this.baseUnit == other.baseUnit;
    }
}
