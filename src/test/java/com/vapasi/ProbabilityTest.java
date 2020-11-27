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
        Probability actual = probability.notGettingChance();
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
    public void shouldReturnPossibilityOfOneOutcome() {
        double productOfNoTails = 0.25;
        Probability expected = new Probability(productOfNoTails);
        Probability notOfOneTail = probability.notGettingChance();
        Probability notOfTails = notOfOneTail.and(notOfOneTail);
        assertEquals(expected, notOfTails);
    }

    @Test
    public void shouldReturnChanceOfLeastOneOutcome() {
        double minimumOneTail = 0.75;
        Probability expected = new Probability(minimumOneTail);
        Probability notOfOneTail = probability.notGettingChance();
        Probability productOfTwoNot = notOfOneTail.and(notOfOneTail);
        Probability actual = productOfTwoNot.notGettingChance();
        assertEquals(expected, actual);
    }



}
