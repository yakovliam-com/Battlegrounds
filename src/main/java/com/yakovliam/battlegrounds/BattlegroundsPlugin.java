package com.yakovliam.battlegrounds;

import com.yakovliam.battlegrounds.game.BattlegroundsGameServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class BattlegroundsPlugin extends JavaPlugin {

    @Override
    public void onLoad() {
    }

    @Override
    public void onEnable() {
        // initialize the game provider
        BattlegroundsGameServiceProvider battlegroundsGameProvider = new BattlegroundsGameServiceProvider(this);
        battlegroundsGameProvider.begin();
    }

    @Override
    public void onDisable() {
    }
}
