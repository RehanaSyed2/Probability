package com.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProbabilityTest {


    @Test
    public void shouldCompareSameValues(){
        Probability probability1 = new Probability(0.5);
        Probability probability2 = new Probability(0.5);
        assertEquals(probability1,probability2);
    }

    @Test
    public void shouldCompareTwoDifferentValues(){
        Probability probability1 = new Probability(0.5);
        Probability probability2 = new Probability(1);
        assertNotEquals(probability1,probability2);
    }

}
