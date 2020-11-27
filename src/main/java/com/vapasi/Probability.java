package com.vapasi;

import java.util.Objects;

public class Probability {

    private final double chance;

    public Probability(double chance) {
        this.chance = chance;
    }

    @Override
    public String toString() {
        return "Probability{" +
                "chance=" + chance +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Probability that = (Probability) object;
        return that.chance == this.chance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chance);
    }

    public double getChance() {
        return chance;
    }

    public Probability not() {
        double noChance = 1 - chance;
        return new Probability(noChance);
    }

    public Probability and(Probability probability) {
        return new Probability(chance * probability.chance);
    }

    public Probability or(Probability that) {
        return (not().and(that.not())).not();
    }
}
