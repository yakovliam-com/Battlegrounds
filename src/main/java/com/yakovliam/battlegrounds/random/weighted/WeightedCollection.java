package com.yakovliam.battlegrounds.random.weighted;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

public class WeightedCollection<E> {

    private final NavigableMap<Double, E> map = new TreeMap<>();
    private final Random random;
    private double total = 0;

    public WeightedCollection() {
        this(new Random());
    }

    public WeightedCollection(Random random) {
        this.random = random;
    }

    public WeightedCollection<E> add(WeightedItem<E> item) {
        if (item.getWeight() <= 0) return this;
        total += item.getWeight();
        map.put(total, item.getItem());
        return this;
    }

    public E next() {
        double value = random.nextDouble() * total;
        return map.higherEntry(value).getValue();
    }
}
