/*
 * Copyright (c) 2025 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.project.training.oo.graph;

import java.util.ArrayList;
import java.util.List;

// Understands a specific route from one Node to another
public final class Path {
    private final List<Link> links = new ArrayList<>();

    void prepend(Link link) {
        links.addFirst(link);
    }

    public int hopCount() {
        return links.size();
    }

    public double cost() {
        return Link.totalCost(links);
    }
}
