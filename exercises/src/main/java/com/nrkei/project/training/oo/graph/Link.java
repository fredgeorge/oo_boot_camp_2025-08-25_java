/*
 * Copyright (c) 2025 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.project.training.oo.graph;

import java.util.List;
import java.util.stream.Stream;

// Understands a connection from one Node to another
public final class Link {
    private final double cost;
    private final Node target;

    public Link(double amount, Node target) {
        this.cost = amount;
        this.target = target;
    }

    static double totalCost(List<Link> links) {
        return links.stream().mapToDouble(l -> l.cost).sum();
    }

    Stream<Path> paths(Node destination, List<Node> visitedNodes) {
        return target.paths(destination, visitedNodes).map(p -> p.prepend(this));
    }
}
