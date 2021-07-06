package com.yakovliam.battlegrounds.bootstrap;

import com.yakovliam.battlegrounds.game.BattlegroundsGameServiceProvider;
import com.yakovliam.battlegrounds.game.listener.BuildListener;
import com.yakovliam.battlegrounds.game.listener.ConnectionListener;
import com.yakovliam.battlegrounds.game.listener.DropListener;

public record GameBootstrapper(
        BattlegroundsGameServiceProvider battlegroundsGameServiceProvider) implements Bootstrapper {

    /**
     * Game bootstrapper
     *
     * @param battlegroundsGameServiceProvider battlegroundsGameServiceProvider
     */
    public GameBootstrapper {
    }

    @Override
    public void init() {
        registerListeners();
    }

    /**
     * Register listeners
     */
    private void registerListeners() {
        new BuildListener(battlegroundsGameServiceProvider);
        new ConnectionListener(battlegroundsGameServiceProvider);
        new DropListener(battlegroundsGameServiceProvider);
    }
}
