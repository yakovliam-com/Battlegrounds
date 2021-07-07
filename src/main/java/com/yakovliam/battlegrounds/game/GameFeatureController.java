package com.yakovliam.battlegrounds.game;

import com.yakovliam.battlegrounds.state.GameStateMovementEvent;

public interface GameFeatureController {

    /**
     * Switches the game state
     * <p>
     * Fired whenever the game state has been changed
     *
     * @param event event
     */
    void switchGameState(GameStateMovementEvent event);
}
