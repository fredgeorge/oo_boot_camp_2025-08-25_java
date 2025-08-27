/*
 * Copyright (c) 2025 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.project.training.oo.graph;

import java.util.List;

// Understands a connection from one Node to another
public final class Link {
    static final CostStrategy LEAST_COST = (double cost) -> cost;
    static final CostStrategy FEWEST_HOPS = (double cost) -> 1.0;
    private final double cost;
    private final Node target;

    public Link(double amount, Node target) {
        this.cost = amount;
        this.target = target;
    }

    static double totalCost(List<Link> links) {
        return links.stream().mapToDouble(l -> l.cost).sum();
    }

    double cost(Node destination, List<Node> visitedNodes, Link.CostStrategy strategy) {
        return target.cost(destination, visitedNodes, strategy) + strategy.cost(cost);
    }

    Path path(Node destination, List<Node> visitedNodes) {
        var result = target.path(destination, visitedNodes);
        if (result != null) result.prepend(this);
        return result;
    }

    interface CostStrategy {
        double cost(double amount);
    }
}
