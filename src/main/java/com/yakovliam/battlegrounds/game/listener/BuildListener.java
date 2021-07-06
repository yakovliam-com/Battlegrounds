package com.yakovliam.battlegrounds.game.listener;

import com.yakovliam.battlegrounds.game.BattlegroundsGameServiceProvider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BuildListener extends GameListener {

    /**
     * Game listener
     * <p>
     * Constructs and registers
     *
     * @param battlegroundsGameServiceProvider battlegroundsGameServiceProvider
     */
    public BuildListener(BattlegroundsGameServiceProvider battlegroundsGameServiceProvider) {
        super(battlegroundsGameServiceProvider);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
    }
}
