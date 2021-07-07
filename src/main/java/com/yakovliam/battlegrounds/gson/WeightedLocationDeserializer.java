package com.yakovliam.battlegrounds.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.yakovliam.battlegrounds.random.WeightedItem;
import org.bukkit.Location;

import java.lang.reflect.Type;
import java.util.regex.Pattern;

public class WeightedLocationDeserializer implements JsonDeserializer<WeightedItem<Location>> {

    private static final Pattern LOCATION_STRING_PATTERN = Pattern.compile("(.+[:|;])(.+)");

    @Override
    public WeightedItem<Location> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        json.getAsString();


        return null;
    }
}
