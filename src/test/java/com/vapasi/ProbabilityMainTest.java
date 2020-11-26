package com.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProbabilityMainTest {

    @Test
    public void shouldReturnNotGettingChanceValue() {
        Probability probability = new Probability(0.5);
        double actual = ProbabilityMain.checkNotGettingChance(probability);
        assertEquals(0.5, actual);
    }

}
