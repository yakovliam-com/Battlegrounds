package com.yakovliam.battlegrounds.random;

public class WeightedItem<E> {

    private static final Double DEFAULT_WEIGHT = 1D;

    private E item;

    private Double weight;

    public WeightedItem(E item, Double weight) {
        this.item = item;
        this.weight = weight;
    }

    public WeightedItem(E item) {
        this.item = item;
        this.weight = DEFAULT_WEIGHT;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
