package org.twu.chance;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TestChance {

    @Test
    public void shouldRepresentChanceOfASingleOutcome(){
        int numberOfOutcomes = 1;
        int totalNumberOfOutcomes = 6;
        Chance chance = new Chance((double)numberOfOutcomes / totalNumberOfOutcomes);
        Chance expectedChance = new Chance((double)1/6);
        assertEquals(expectedChance, chance);
    }

    @Test
    public void shouldRepresentEqualityOfChanceOf3And5(){
        int numberOfOutcomesFor3 = 1;
        int numberOfOutcomesFor5 = 1;
        int totalNumberOfOutcomes = 6;
        Chance chanceFor3 = Chance.createChance(numberOfOutcomesFor3, totalNumberOfOutcomes);
        Chance chanceFor5 = Chance.createChance(numberOfOutcomesFor5, totalNumberOfOutcomes);
        assertEquals(chanceFor3, chanceFor5);
    }

    @Test
    public void shouldRepresentEqualChances() {
        int numberOfOutcomesForDice = 3;
        int totalNumberOfOutcomesForDice = 6;

        int numberOfOutcomesForCoin = 1;
        int totalNumberOfOutcomesForCoin = 2;

        Chance chanceForDice = Chance.createChance(numberOfOutcomesForDice, totalNumberOfOutcomesForDice);
        Chance chanceForCoin = Chance.createChance(numberOfOutcomesForCoin, totalNumberOfOutcomesForCoin);

        assertEquals(chanceForDice, chanceForCoin);
    }

    @Test
    public void shouldRepresentChanceNotGettingThreeForADice() {
        int numberOfOutcomesForDice = 1;
        int totalNumberOfOutcomesForDice = 6;

        Chance chanceForDice = Chance.createChance(numberOfOutcomesForDice, totalNumberOfOutcomesForDice);
        int expectedNumberOfOutcome = 5;
        int expectedTotalNumberOfOutcomesForDice = 6;

        Chance expectedChance = Chance.createChance(expectedNumberOfOutcome, expectedTotalNumberOfOutcomesForDice);
        assertEquals(expectedChance, chanceForDice.not());
    }

    @Test
    public void shouldMultiplyChancesOfTwoEvents(){
        int numberOfOutcomes = 1;
        int totalNumberOfOutcomes = 6;
        Chance chanceOfEventOne = Chance.createChance(numberOfOutcomes, totalNumberOfOutcomes);
        Chance chanceOfEventTwo = Chance.createChance(numberOfOutcomes, totalNumberOfOutcomes);
        Chance product =  chanceOfEventOne.and(chanceOfEventTwo);
        Chance expectedChance = Chance.createChance(1, 36);
        assertEquals(expectedChance,product);
    }

    @Test
    public void shouldRepresentChanceOfEitherAOrB(){
        int numberOfOutcomes = 1;
        int totalNumberOfOutcomes = 6;
        Chance chanceOfEventOne = Chance.createChance(numberOfOutcomes, totalNumberOfOutcomes);
        Chance chanceOfEventTwo = Chance.createChance(numberOfOutcomes, totalNumberOfOutcomes);
        Chance product =  chanceOfEventOne.or(chanceOfEventTwo);
        Chance expectedChance = Chance.createChance(11, 36);
        assertEquals(expectedChance,product);
    }


}
