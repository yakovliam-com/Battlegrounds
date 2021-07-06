package com.yakovliam.battlegrounds.state;

public enum GameState {

    PREPARING,
    WAITING_FOR_PLAYERS,
    STARTING, // possibly removed in the future
    IN_PROGRESS,
    CLEANING_UP, // possibly removed in the future
    ENDED;

    /**
     * Returns the default game state
     *
     * @return default game state
     */
    public static GameState getDefault() {
        return PREPARING;
    }
}
