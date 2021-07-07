package com.yakovliam.battlegrounds.game.event.listener.inprogress;

import com.yakovliam.battlegrounds.game.BattlegroundsGameServiceProvider;
import com.yakovliam.battlegrounds.game.event.listener.DropListener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class IPDropListener extends DropListener {

    /**
     * Game listener
     * <p>
     * Constructs and registers
     *
     * @param battlegroundsGameServiceProvider battlegroundsGameServiceProvider
     */
    public IPDropListener(BattlegroundsGameServiceProvider battlegroundsGameServiceProvider) {
        super(battlegroundsGameServiceProvider);
    }

    @Override
    public void onPlayerDropItem(PlayerDropItemEvent event) {
    }
}
