package com.vapasi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sun.plugin2.message.GetAppletMessage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProbabilityTest {
   public static final double GET_CHANCE=0.5;
   public static final double NO_CHANCE=1-GET_CHANCE;
   public static Probability probability;

    @BeforeAll
    public static void setUp(){
        probability = new Probability(GET_CHANCE);
    }
    @Test
    public void shouldCompareSameValues(){
        Probability probability2 = new Probability(GET_CHANCE);
        assertEquals(probability,probability2);
    }

    @Test
    public void shouldCompareTwoDifferentValues(){
        Probability probability2 = new Probability(1);
        assertNotEquals(probability,probability2);
    }

    @Test
    public void shouldReturnNotGettingChanceValue() {
        Probability noProb = new Probability(NO_CHANCE);
        Probability actual = probability.not();
        assertEquals(noProb, actual);
    }

    @Test
    public void shouldReturnProbabilityOfTwoEvent() {
        double productOfTwo = 0.25;
        Probability anotherProbability=new Probability(GET_CHANCE);
        Probability actual = probability.and(anotherProbability);
        Probability expectedProb = new Probability(productOfTwo);
        assertEquals(expectedProb, actual);
    }

    @Test
    public void shouldReturnChanceOfLeastOneOutcome() {
        double minimumOneTail = 0.75;
        Probability expected = new Probability(minimumOneTail);
        Probability anotherProbability = new Probability(GET_CHANCE);
        Probability actual = probability.or(anotherProbability);
        assertEquals(expected, actual);
    }



}
