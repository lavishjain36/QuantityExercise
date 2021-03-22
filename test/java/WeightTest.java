import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeightTest {
    @Test
    public void testEqualsIsTrueFor1GramEquals1Gram() throws IllegalArgumentException {
        double weightInGram = 1;
        WeightUtilities firstMeasurement = new WeightUtilities(weightInGram, UnitOfWeight.Gram);
        WeightUtilities secondMeasurement = new WeightUtilities(weightInGram, UnitOfWeight.Gram);

        boolean actual = firstMeasurement.equals(secondMeasurement);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsFalseFor2GramsEquals1Gram() throws IllegalArgumentException {
        double twoGramWeight = 2;
        double oneGramWeight = 1;
        WeightUtilities firstMeasurement = new WeightUtilities(twoGramWeight, UnitOfWeight.Gram);
        WeightUtilities secondMeasurement = new WeightUtilities(oneGramWeight, UnitOfWeight.Gram);

        boolean actual = firstMeasurement.equals(secondMeasurement);

        assertFalse(actual);
    }

    @Test
    public void testThrowsExceptionForNegativeValuedDimension() {
        double gramWeight = -1;

        assertThrows(IllegalArgumentException.class, () -> new WeightUtilities(gramWeight, UnitOfWeight.Gram));
    }

    @Test
    public void testThrowsExceptionForZeroValuedDimension() {
        double gramWeight = 0;

        assertThrows(IllegalArgumentException.class, () -> new WeightUtilities(gramWeight, UnitOfWeight.Gram));
    }

    @Test
    public void testEqualsIsTrueForOneTenthKilogramEquals100Gram() throws IllegalArgumentException {
        double oneTenthOfkilogramWeight = 0.1;
        double hundredGramWeight = 100;
        WeightUtilities measurementInKilogram = new WeightUtilities(oneTenthOfkilogramWeight, UnitOfWeight.Kilogram);
        WeightUtilities measurementInGram = new WeightUtilities(hundredGramWeight, UnitOfWeight.Gram);

        boolean actual = measurementInKilogram.equals(measurementInGram);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsTrueFor100GramsEqualsOneTenthKilogram() throws IllegalArgumentException {
        double oneTenthOfkilogramWeight = 0.1;
        double hundredGramWeight = 100;
        WeightUtilities measurementInKilogram = new WeightUtilities(oneTenthOfkilogramWeight, UnitOfWeight.Kilogram);
        WeightUtilities measurementInGram = new WeightUtilities(hundredGramWeight, UnitOfWeight.Gram);

        assertEquals(measurementInGram, measurementInKilogram);
    }

    @Test
    public void testAddIs1010GramFor10GramAnd1Kilogram() throws IllegalArgumentException {
        double onekilogramWeight = 1;
        double tenGramWeight = 10;
        WeightUtilities measurementInKilogram = new WeightUtilities(onekilogramWeight, UnitOfWeight.Kilogram);
        WeightUtilities measurementInGram = new WeightUtilities(tenGramWeight, UnitOfWeight.Gram);
        WeightUtilities expectedSum = new WeightUtilities(1020, UnitOfWeight.Gram);

        WeightUtilities actualSum = (WeightUtilities) measurementInKilogram.add(measurementInGram).add(measurementInGram);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testSubtractIs1KilogramForRemoving500GramsFromOneAndAHalfKilogram() throws IllegalArgumentException {
        double oneAndAHalfkilogramWeight = 1.5;
        double fiveHundredGramWeight = 500;
        WeightUtilities measurementInKilogram = new WeightUtilities(oneAndAHalfkilogramWeight, UnitOfWeight.Kilogram);
        WeightUtilities measurementInGram = new WeightUtilities(fiveHundredGramWeight, UnitOfWeight.Gram);
        WeightUtilities expectedDifference = new WeightUtilities(1, UnitOfWeight.Kilogram);

        WeightUtilities actualDifference = (WeightUtilities) measurementInKilogram.subtract(measurementInGram);

        assertEquals(expectedDifference, actualDifference);
    }

    @Test
    public void testSubtractThrowsExceptionForRemoving1GramFrom50Gram() throws IllegalArgumentException {
        double oneGramWeight = 1;
        double fiftyGramWeight = 50;
        WeightUtilities measurementOfOneGram = new WeightUtilities(oneGramWeight, UnitOfWeight.Gram);
        WeightUtilities measurementOf50Gram = new WeightUtilities(fiftyGramWeight, UnitOfWeight.Gram);

        assertThrows(IllegalArgumentException.class, () -> measurementOfOneGram.subtract(measurementOf50Gram));
    }

    @Test
    public void testSubtractThrowsExceptionForRemoving1MeterFrom1Meter() throws IllegalArgumentException {
        double fiftyGramWeight = 50;
        WeightUtilities measurementOf50Gram = new WeightUtilities(fiftyGramWeight, UnitOfWeight.Gram);

        assertThrows(IllegalArgumentException.class, () -> measurementOf50Gram.subtract(measurementOf50Gram));
    }
}
