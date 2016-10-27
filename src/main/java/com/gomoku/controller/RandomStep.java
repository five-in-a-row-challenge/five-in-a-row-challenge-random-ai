package com.gomoku.controller;

/**
 * It contains coordinates: the x, and y fields of the board.
 */
public class RandomStep {

    private final int x;

    private final int y;

    public RandomStep(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
