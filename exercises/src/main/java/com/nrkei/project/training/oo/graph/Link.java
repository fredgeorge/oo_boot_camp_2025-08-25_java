/*
 * Copyright (c) 2025 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.project.training.oo.graph;

import java.util.List;

// Understands a connection from one Node to another
public final class Link {
    private final double amount;
    private final Node target;

    public Link(double amount, Node target) {
        this.amount = amount;
        this.target = target;
    }

    double hopCount(Node destination, List<Node> visitedNodes) {
        return target.hopCount(destination, visitedNodes) + 1;
    }
}
