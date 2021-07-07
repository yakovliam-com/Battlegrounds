package com.yakovliam.battlegrounds.game.event.listener;

import com.yakovliam.battlegrounds.game.BattlegroundsGameServiceProvider;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public abstract class BuildListener extends EventListener {

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

    public abstract void onBlockBreak(BlockBreakEvent event);

    public abstract void onBlockPlace(BlockPlaceEvent event);
}
