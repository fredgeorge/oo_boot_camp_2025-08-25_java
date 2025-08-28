/*
 * Copyright (c) 2025 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.project.training.oo.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// Understands a specific route from one Node to another
public class Path {
    private final Node destination;

    Path(Node destination) {
        this.destination = destination;
    }

    static Stream<Path> filter(Stream<Path> paths, Node destination) {
        return paths.filter(p -> p.destination == destination);
    }
    private final List<Link> links = new ArrayList<>();

    Path prepend(Link link) {
        links.addFirst(link);
        return this;
    }

    public int hopCount() {
        return links.size();
    }

    public double cost() {
        return Link.totalCost(links);
    }
}
