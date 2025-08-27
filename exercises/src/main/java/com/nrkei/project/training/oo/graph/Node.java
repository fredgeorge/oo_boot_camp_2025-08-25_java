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
import java.util.stream.Stream;

// Understands its neighbors
public final class Node {
    private static final List<Node> NO_VISITED_NODES = new ArrayList<>();
    private final List<Link> links = new ArrayList<>();

    public boolean canReach(Node destination) {
        return !paths(destination).isEmpty();
    }

    public int hopCount(Node destination) {
        return path(destination, Path::hopCount).hopCount();
    }

    public double cost(Node destination) {
        return path(destination).cost();
    }

    public Path path(Node destination) {
        return path(destination, Path::cost);
    }

    public List<Path> paths(Node destination) {
        return paths(destination, NO_VISITED_NODES).toList();
    }

    public Stream<Path> paths(Node destination, List<Node> visitedNodes) {
        if (this == destination) return Stream.of(new Path());
        if (visitedNodes.contains(this)) return Stream.empty();
        return links.stream()
                .flatMap(link -> link.paths(destination, copyWithThis(visitedNodes)));
    }

    private Path path(Node destination, ToDoubleFunction<Path> strategy) {
        return paths(destination).stream()
                .min(Comparator.comparingDouble(strategy))
                .orElseThrow(() -> new IllegalArgumentException("Destination is unreachable"));
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
