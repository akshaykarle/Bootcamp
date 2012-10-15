package org.twu.chance;
//Job: Understands probability of a set of outcomes given the total number of possible outcomes

import java.math.BigDecimal;
import java.math.MathContext;

public class Chance {
    private double probablitity;

    public Chance(double value) {
        this.probablitity = value;
    }

    static Chance createChance(int numberOfOutcomes, int totalNumberOfOutcomes) {
        return new Chance((double) numberOfOutcomes / totalNumberOfOutcomes);
    }

    @Override
    public boolean equals(Object anotherObject) {
        if (!(anotherObject instanceof Chance)) {
            return false;
        }
        Chance otherChance = (Chance) anotherObject;
        MathContext rounding = new MathContext(3);
        return new BigDecimal(this.probablitity, rounding).equals(new BigDecimal(otherChance.probablitity, rounding));
    }


    public Chance not() {
        return new Chance(1 - probablitity);
    }

    public Chance and(Chance chanceOfEventOne) {
        return new Chance((this.probablitity * chanceOfEventOne.probablitity));
    }

    public Chance or(Chance chanceOfEventTwo) {
        Chance result = this.not().and(chanceOfEventTwo.not());
        return result.not();
    }
}
