package com.yakovliam.battlegrounds.calculator;

import com.yakovliam.battlegrounds.random.RandomCollection;
import com.yakovliam.battlegrounds.random.WeightedItem;
import com.yakovliam.battlegrounds.serialization.location.WeightedLocationListDeserializer;
import org.bukkit.Location;

import java.util.List;

public class RandomLobbyLocationCalculator implements Calculator<List<String>, Location> {

    @Override
    public Location calculate(List<String> context) {
        // deserialize into a list of weighted probability items
        List<WeightedItem<Location>> weightedItems = new WeightedLocationListDeserializer().deserialize(context);

        // create random collection
        RandomCollection<Location> randomCollection = new RandomCollection<>();
        for (WeightedItem<Location> weightedItem : weightedItems) {
            randomCollection.add(weightedItem);
        }

        return randomCollection.next();
    }
}
