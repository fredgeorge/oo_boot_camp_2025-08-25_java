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
    static final Path NO_PATH = new None();

    Path prepend(Link link) {
        return this;
    }

    public abstract int hopCount();

    public abstract double cost();

    static class ActualPath extends Path {
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

    private static class None extends Path {

        @Override
        public int hopCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public double cost() {
            return Double.POSITIVE_INFINITY;
        }
    }
}
