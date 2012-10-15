package org.twu.chance;
//Job: Understands probability of a set of outcomes given the total number of possible outcomes

import java.math.BigDecimal;
import java.math.MathContext;

public class Chance {
    private double value;

    public Chance(double value) {

        this.value = value;
    }

    public static Chance createChance(int numberOfOutcomes, int totalNumberOfOutcomes) {
        double value = (double) numberOfOutcomes / totalNumberOfOutcomes;
        return new Chance(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chance otherChance = (Chance) o;

        MathContext rounding = new MathContext(3);
        return new BigDecimal(this.value, rounding)
                .equals(new BigDecimal(otherChance.value, rounding));

    }

    @Override
    public int hashCode() {
        long temp = value != +0.0d ? Double.doubleToLongBits(value) : 0L;
        return (int) (temp ^ (temp >>> 32));
    }


    public Chance not() {
        return new Chance(1-value);
    }

    public Chance and(Chance anotherChance) {
        return new Chance(this.value * anotherChance.value);
    }

    @Override
    public String toString() {
        return "Chance{" +
                "value=" + value +
                '}';
    }

    public Chance or(Chance anotherChance) {
        Chance noChanceForThis = this.not();
        Chance noChanceForAnother = anotherChance.not();
        Chance noChanceForThisAndAnother = noChanceForThis.and(noChanceForAnother);
        Chance chanceForThisOrAnother = noChanceForThisAndAnother.not();
        return new Chance(chanceForThisOrAnother.value);
    }
}
