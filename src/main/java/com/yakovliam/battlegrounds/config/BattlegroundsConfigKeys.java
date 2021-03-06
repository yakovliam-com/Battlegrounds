package com.yakovliam.battlegrounds.config;

import com.yakovliam.battlegrounds.builder.WaitingBroadcastListBuilder;
import com.yakovliam.battlegrounds.calculator.RandomLobbyLocationCalculator;
import com.yakovliam.battlegrounds.calculator.RandomWaitingBroadcastMessageCalculator;
import com.yakovliam.battlegrounds.config.generic.KeyedConfiguration;
import com.yakovliam.battlegrounds.config.generic.key.ConfigKey;
import com.yakovliam.battlegrounds.config.generic.key.SimpleConfigKey;
import com.yakovliam.battlegrounds.message.Message;
import com.yakovliam.battlegrounds.util.Pair;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

import static com.yakovliam.battlegrounds.config.generic.key.ConfigKeyFactory.key;

public class BattlegroundsConfigKeys {

    /**
     * The required # of players to start the game
     */
    public static final ConfigKey<Integer> REQUIRED_PLAYERS_TO_START = key(c -> c.getInteger("game.required-players-to-start", 10));

    /**
     * Calculates and returns a random lobby spawn location
     */
    public static final ConfigKey<Location> RANDOM_LOBBY_SPAWN_LOCATION = key(c -> {
        List<String> serializedSpawnLocations = c.getStringList("game.waiting.lobby.spawn-locations", new ArrayList<>());
        if (serializedSpawnLocations.isEmpty()) {
            return null;
        }

        return new RandomLobbyLocationCalculator().calculate(serializedSpawnLocations);
    });

    public static final ConfigKey<Message> RANDOM_WAITING_BROADCAST_MESSAGE = key(c -> {
        // build messages list
        List<Message> messages = new WaitingBroadcastListBuilder().build(new Pair<>(c, "game.waiting.random-tips"));
        // calculate random
        return new RandomWaitingBroadcastMessageCalculator().calculate(messages);
    });

    private static final List<SimpleConfigKey<?>> KEYS = KeyedConfiguration.initialise(BattlegroundsConfigKeys.class);

    public static List<? extends ConfigKey<?>> getKeys() {
        return KEYS;
    }
}
