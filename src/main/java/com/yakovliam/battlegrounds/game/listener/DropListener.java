package com.yakovliam.battlegrounds.game.listener;

import com.yakovliam.battlegrounds.game.BattlegroundsGameServiceProvider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropListener extends GameListener {

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

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        // cancel
        event.setCancelled(true);
    }
}
