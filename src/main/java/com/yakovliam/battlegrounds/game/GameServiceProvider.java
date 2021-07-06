package com.yakovliam.battlegrounds.game;

public interface GameServiceProvider {

    /**
     * Begins a session
     * <p>
     * The first step in the process
     */
    void begin();

    /**
     * Ends the current session
     * <p>
     * The final step in the process
     */
    void end();

}
