package com.yakovliam.battlegrounds.util;

public record Pair<L, R>(L left, R right) {

    /**
     * Pair
     *
     * @param left  left
     * @param right right
     */
    public Pair {
    }


    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }
}
