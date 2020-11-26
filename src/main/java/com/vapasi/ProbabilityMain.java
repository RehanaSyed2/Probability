package com.vapasi;

public class ProbabilityMain {


    public static double checkNotGettingChance(Probability probability) {
        double noChance = 1 - probability.getChance();
        return noChance;
    }
}
