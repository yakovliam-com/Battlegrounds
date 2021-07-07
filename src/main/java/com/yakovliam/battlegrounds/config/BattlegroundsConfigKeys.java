package com.yakovliam.battlegrounds.config;

import com.yakovliam.battlegrounds.config.generic.KeyedConfiguration;
import com.yakovliam.battlegrounds.config.generic.key.ConfigKey;
import com.yakovliam.battlegrounds.config.generic.key.SimpleConfigKey;

import java.util.List;

import static com.yakovliam.battlegrounds.config.generic.key.ConfigKeyFactory.key;

public class BattlegroundsConfigKeys {

    /**
     * The required # of players to start the game
     */
    public static final ConfigKey<Integer> REQUIRED_PLAYERS_TO_START = key(c -> c.getInteger("game.required-players-to-start", 10));

    private static final List<SimpleConfigKey<?>> KEYS = KeyedConfiguration.initialise(BattlegroundsConfigKeys.class);

    public static List<? extends ConfigKey<?>> getKeys() {
        return KEYS;
    }
}
