/*
 * Copyright (c) 2025 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.project.training.oo.graph;

import java.util.ArrayList;
import java.util.List;

// Understands a specific route from one Node to another
public abstract class Path {

    void prepend(Link link) {
    }

    public abstract int hopCount();

    public abstract double cost();

    static class ActualPath extends Path {
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
}
