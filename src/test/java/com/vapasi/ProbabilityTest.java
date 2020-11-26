package com.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProbabilityTest {


    @Test
    public void shouldCompareTwoValueObjects(){
        Probability probability1 = new Probability(0.5);
        Probability probability2 = new Probability(0.5);
        assertEquals(probability1,probability2);
    }

}
