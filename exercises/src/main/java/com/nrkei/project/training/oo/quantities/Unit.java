/*
 * Copyright (c) 2025 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.project.training.oo.quantities;

// Understands a specific metric
public final class Unit {
    public static final Unit TEASPOON = new Unit();
    public static final Unit TABLESPOON = new Unit();
    public static final Unit OUNCE = new Unit();
    public static final Unit CUP = new Unit();
    public static final Unit PINT = new Unit();
    public static final Unit QUART = new Unit();
    public static final Unit GALLON = new Unit();

    public Quantity s(double amount) {
        return new Quantity(amount, this);
    }
}
