package com.yakovliam.battlegrounds.calculator;

import com.yakovliam.battlegrounds.random.weighted.WeightedCollection;
import com.yakovliam.battlegrounds.random.weighted.WeightedItem;
import com.yakovliam.battlegrounds.serialization.location.WeightedLocationListDeserializer;
import org.bukkit.Location;

import java.util.List;

public class RandomLobbyLocationCalculator implements Calculator<List<String>, Location> {

    @Override
    public Location calculate(List<String> context) {
        // deserialize into a list of weighted probability items
        List<WeightedItem<Location>> weightedItems = new WeightedLocationListDeserializer().deserialize(context);

        // create random collection
        WeightedCollection<Location> weightedCollection = new WeightedCollection<>();
        for (WeightedItem<Location> weightedItem : weightedItems) {
            weightedCollection.add(weightedItem);
        }

        return weightedCollection.next();
    }
}
