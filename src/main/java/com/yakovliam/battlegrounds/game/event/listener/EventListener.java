package com.yakovliam.battlegrounds.game.event.listener;

import com.yakovliam.battlegrounds.game.BattlegroundsGameServiceProvider;

public abstract class EventListener {

    /**
     * Battlegrounds game service provider
     */
    protected final BattlegroundsGameServiceProvider battlegroundsGameServiceProvider;

    /**
     * Game listener
     * <p>
     * Constructs and registers
     *
     * @param battlegroundsGameServiceProvider battlegroundsGameServiceProvider
     */
    public EventListener(BattlegroundsGameServiceProvider battlegroundsGameServiceProvider) {
        this.battlegroundsGameServiceProvider = battlegroundsGameServiceProvider;
    }
}
