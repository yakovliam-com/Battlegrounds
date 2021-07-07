package com.yakovliam.battlegrounds.game.event.listener;

import com.yakovliam.battlegrounds.game.BattlegroundsGameServiceProvider;
import org.bukkit.event.player.PlayerDropItemEvent;

public abstract class DropListener extends EventListener {

    /**
     * Game listener
     * <p>
     * Constructs and registers
     *
     * @param battlegroundsGameServiceProvider battlegroundsGameServiceProvider
     */
    public DropListener(BattlegroundsGameServiceProvider battlegroundsGameServiceProvider) {
        super(battlegroundsGameServiceProvider);
    }

    public abstract void onPlayerDropItem(PlayerDropItemEvent event);
}
