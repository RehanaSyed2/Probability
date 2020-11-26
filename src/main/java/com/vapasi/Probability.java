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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Probability that = (Probability) o;
        return Double.compare(that.chance, chance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chance);
    }
}
