package com.yakovliam.battlegrounds.serialization.location;

import com.yakovliam.battlegrounds.random.weighted.WeightedItem;
import com.yakovliam.battlegrounds.serialization.Deserializer;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeightedLocationListDeserializer implements Deserializer<List<String>, List<WeightedItem<Location>>> {

    private static final Pattern LOCATION_STRING_PATTERN = Pattern.compile("(.+[:|;])(.+)");

    @Override
    public List<WeightedItem<Location>> deserialize(List<String> strings) {
        List<WeightedItem<Location>> weightedItems = new ArrayList<>();

        // loop through and create
        for (String string : strings) {
            List<String> parsedData = new ArrayList<>();

            // match patterns
            Matcher matcher = LOCATION_STRING_PATTERN.matcher(string);

            while (matcher.find()) {
                String data = matcher.group();
                parsedData.add(data);
            }

            // create item
            String world = parsedData.get(0);
            double x = Double.parseDouble(parsedData.get(1));
            double y = Double.parseDouble(parsedData.get(2));
            double z = Double.parseDouble(parsedData.get(3));
            float yaw = Float.parseFloat(parsedData.get(4));
            float pitch = Float.parseFloat(parsedData.get(5));
            Double weight = null;
            if (parsedData.size() > 6) {
                weight = Double.parseDouble(parsedData.get(6));
            }

            Location location = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
            WeightedItem<Location> weightedItem = weight != null ? new WeightedItem<>(location, weight) : new WeightedItem<>(location);

            weightedItems.add(weightedItem);
        }

        return weightedItems;
    }
}
