package com.gomoku.controller;

import java.util.Random;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for handle next step by random ai algorithm.
 *
 * @author zeldan
 *
 */
@RestController
public class RandomAiController {

    private static final char NONE = 'N';
    private final Random random = new Random();

    @RequestMapping(value = "/nextMove")
    public RandomStep nextStep(
            @PathParam("width") final int width,
            @PathParam("height") final int height,
            @PathParam("player") final Character player,
            @PathParam("table") final String table) {
        RandomStep step = null;
        while (step == null) {
            final int randomX = generateRandomNumber(width);
            final int randomY = generateRandomNumber(height);
            final int index = randomX + randomY * height;
            if (isTableEmpty(table, index)) {
                step = new RandomStep(randomX + 1, randomY + 1);
            }
        }
        return step;
    }

    private boolean isTableEmpty(final String table, final int index) {
        return table.charAt(index) == NONE;
    }

    private int generateRandomNumber(final int bound) {
        return random.nextInt(bound);
    }
}
