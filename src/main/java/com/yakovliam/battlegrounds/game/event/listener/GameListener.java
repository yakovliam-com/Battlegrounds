package com.yakovliam.battlegrounds.game.event.listener;

import com.yakovliam.battlegrounds.game.BattlegroundsGameServiceProvider;
import org.bukkit.event.Listener;

public abstract class GameListener implements Listener {

    /**
     * Service provider
     */
    protected BattlegroundsGameServiceProvider battlegroundsGameServiceProvider;

    /**
     * Game listener
     * <p>
     * Constructs and registers
     *
     * @param battlegroundsGameServiceProvider battlegroundsGameServiceProvider
     */
    public GameListener(BattlegroundsGameServiceProvider battlegroundsGameServiceProvider) {
        this.battlegroundsGameServiceProvider = battlegroundsGameServiceProvider;
        battlegroundsGameServiceProvider.getPlugin()
                .getServer()
                .getPluginManager()
                .registerEvents(this, battlegroundsGameServiceProvider.getPlugin());
    }
}
