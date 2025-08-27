/*
 * Copyright (c) 2025 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.project.training.oo.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToDoubleFunction;

import static com.nrkei.project.training.oo.graph.Path.*;

// Understands its neighbors
public final class Node {
    private static final double UNREACHABLE = Double.POSITIVE_INFINITY;
    private static final List<Node> NO_VISITED_NODES = new ArrayList<>();
    private final List<Link> links = new ArrayList<>();

    public boolean canReach(Node destination) {
        return cost(destination, NO_VISITED_NODES, Link.LEAST_COST) != UNREACHABLE;
    }

    public int hopCount(Node destination) {
        return (int)cost(destination, Link.FEWEST_HOPS);
    }

    public double cost(Node destination) {
        return cost(destination, Link.LEAST_COST);
    }

    public Path path(Node destination) {
        var result = path(destination, NO_VISITED_NODES, Path::cost);
        if (result == NO_PATH) throw new IllegalArgumentException("Destination is unreachable");
        return result;
    }

    Path path(Node destination, List<Node> visitedNodes, ToDoubleFunction<Path> strategy) {
        if (this == destination) return new ActualPath();
        if (visitedNodes.contains(this)) return NO_PATH;
        return links.stream()
                .map(link -> link.path(destination, copyWithThis(visitedNodes), strategy))
                .min(Comparator.comparingDouble(strategy))
                .orElse(NO_PATH);
    }

    private double cost(Node destination, Link.CostStrategy strategy) {
        var result = cost(destination, NO_VISITED_NODES, strategy);
        if (result == UNREACHABLE) throw new IllegalArgumentException("Destination is unreachable");
        return result;
    }

    double cost(Node destination, List<Node> visitedNodes, Link.CostStrategy strategy) {
        if (this == destination) return 0;
        if (visitedNodes.contains(this)) return UNREACHABLE;
        return links.stream()
                .mapToDouble(link -> link.cost(destination, copyWithThis(visitedNodes), strategy))
                .min()
                .orElse(UNREACHABLE);
    }

    private List<Node> copyWithThis(List<Node> originals) {
        List<Node> results = new ArrayList<>(originals);
        results.add(this);
        return results;
    }

    public LinkBuilder cost(double amount) {
        return new LinkBuilder(amount);
    }

    public class LinkBuilder {
        private final double amount;
        LinkBuilder(double amount) {
            this.amount = amount;
        }

        public Node to(Node neighbor) {
            links.add(new Link(amount, neighbor));
            return neighbor;
        }
    }
}
