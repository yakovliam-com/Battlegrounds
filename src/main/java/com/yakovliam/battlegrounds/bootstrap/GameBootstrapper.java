package com.yakovliam.battlegrounds.bootstrap;

import com.yakovliam.battlegrounds.game.BattlegroundsGameServiceProvider;

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
    }
}
