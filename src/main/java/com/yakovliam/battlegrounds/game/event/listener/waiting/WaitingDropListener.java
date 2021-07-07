package com.yakovliam.battlegrounds.game.event.listener.waiting;

import com.yakovliam.battlegrounds.game.BattlegroundsGameServiceProvider;
import com.yakovliam.battlegrounds.game.event.listener.DropListener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class WaitingDropListener extends DropListener {

    /**
     * Game listener
     * <p>
     * Constructs and registers
     *
     * @param battlegroundsGameServiceProvider battlegroundsGameServiceProvider
     */
    public WaitingDropListener(BattlegroundsGameServiceProvider battlegroundsGameServiceProvider) {
        super(battlegroundsGameServiceProvider);
    }

    @Override
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        // cancel
        event.setCancelled(true);
    }
}
