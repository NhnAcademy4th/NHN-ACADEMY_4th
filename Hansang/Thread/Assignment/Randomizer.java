package com.nhnacademy.Assignment;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    public Randomizer() {
    }

    public int getRandomBound(int start, int end) {
        return random.nextInt(start, end);
    }

    public int getRandomAny() {
        return random.nextInt();
    }

}
