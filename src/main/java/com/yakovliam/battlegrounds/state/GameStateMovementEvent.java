package com.yakovliam.battlegrounds.state;

public class GameStateMovementEvent {

    /**
     * Previous state
     */
    private GameState previous;

    /**
     * Current/New state
     */
    private GameState current;

    /**
     * Game state movement event
     *
     * @param previous previous
     * @param current  current
     */
    public GameStateMovementEvent(GameState previous, GameState current) {
        this.previous = previous;
        this.current = current;
    }

    public GameState getPrevious() {
        return previous;
    }

    public void setPrevious(GameState previous) {
        this.previous = previous;
    }

    public GameState getCurrent() {
        return current;
    }

    public void setCurrent(GameState current) {
        this.current = current;
    }

    /**
     * If the event is to X
     *
     * @param current current
     * @return is
     */
    public boolean isTo(GameState current) {
        return this.current == current;
    }

    /**
     * If the event is from X
     *
     * @param previous previous
     * @return is
     */
    public boolean isFrom(GameState previous) {
        return this.previous == previous;
    }

    /**
     * If the event is from X and to X
     *
     * @param previous previous
     * @param current  current
     * @return is
     */
    public boolean is(GameState previous, GameState current) {
        return this.current == current && this.previous == previous;
    }
}
