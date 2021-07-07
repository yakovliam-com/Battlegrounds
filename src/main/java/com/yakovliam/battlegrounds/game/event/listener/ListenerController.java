package com.yakovliam.battlegrounds.game.event.listener;

import com.yakovliam.battlegrounds.game.BattlegroundsGameServiceProvider;

public abstract class ListenerController extends GameListener {

    /**
     * Build listener
     */
    protected BuildListener buildListener;

    /**
     * Connection listener
     */
    protected ConnectionListener connectionListener;

    /**
     * Drop listener
     */
    protected DropListener dropListener;

    /**
     * Game listener
     * <p>
     * Constructs and registers
     *
     * @param battlegroundsGameServiceProvider battlegroundsGameServiceProvider
     * @param buildListener                    build listener
     * @param connectionListener               connection listener
     * @param dropListener                     drop listener
     */
    public ListenerController(BattlegroundsGameServiceProvider battlegroundsGameServiceProvider, BuildListener buildListener, ConnectionListener connectionListener, DropListener dropListener) {
        super(battlegroundsGameServiceProvider);
    }
}
