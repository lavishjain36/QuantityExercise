import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LengthUtilitiesTest {

    @Test
    public void testEqualsIsTrueFor1CentimeterEquals1Centimeter() throws IllegalArgumentException {
        double dimension = 1;
        LengthUtilities firstMeasurement = new LengthUtilities(dimension, UnitOfLength.Centimeter);
        LengthUtilities secondMeasurement = new LengthUtilities(dimension, UnitOfLength.Centimeter);

        boolean actual = firstMeasurement.equals(secondMeasurement);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsFalseFor2CentimeterEquals1Centimeter() throws IllegalArgumentException {
        double firstDimension = 2;
        double secondDimension = 1;
        LengthUtilities firstMeasurement = new LengthUtilities(firstDimension, UnitOfLength.Centimeter);
        LengthUtilities secondMeasurement = new LengthUtilities(secondDimension, UnitOfLength.Centimeter);

        boolean actual = firstMeasurement.equals(secondMeasurement);

        assertFalse(actual);
    }

    @Test
    public void testEqualsIsTrueForSameMeasurementInstance() throws IllegalArgumentException {
        double dimension = 1;
        LengthUtilities measurement = new LengthUtilities(dimension, UnitOfLength.Centimeter);

        boolean actual = measurement.equals(measurement);

        assertTrue(actual);
    }

    @Test
    public void testThrowsExceptionForNegativeValuedDimension() {
        double dimension = -1;

        assertThrows(IllegalArgumentException.class, () -> new LengthUtilities(dimension, UnitOfLength.Centimeter));
    }

    @Test
    public void testThrowsExceptionForZeroValuedDimension() {
        double dimension = 0;

        assertThrows(IllegalArgumentException.class, () -> new LengthUtilities(dimension, UnitOfLength.Centimeter));
    }

    @Test
    public void testEqualsIsTrueFor1MeterEquals100Centimeter() throws IllegalArgumentException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        LengthUtilities measurementInCentimeter = new LengthUtilities(dimensionInCentimeter, UnitOfLength.Centimeter);
        LengthUtilities measurementInMeter = new LengthUtilities(dimensionInMeter, UnitOfLength.Meter);

        boolean actual = measurementInCentimeter.equals(measurementInMeter);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsTrueFor100CentimeterEquals1Meter() throws IllegalArgumentException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        LengthUtilities measurementInCentimeter = new LengthUtilities(dimensionInCentimeter, UnitOfLength.Centimeter);
        LengthUtilities measurementInMeter = new LengthUtilities(dimensionInMeter, UnitOfLength.Meter);

        boolean actual = measurementInMeter.equals(measurementInCentimeter);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsTrueFor100CentimeterEqualsOneThousandthKilometer() throws IllegalArgumentException {
        double dimensionInCentimeter = 100;
        double dimensionInKilometer = 0.001;
        LengthUtilities measurementInCentimeter = new LengthUtilities(dimensionInCentimeter, UnitOfLength.Centimeter);
        LengthUtilities measurementInKilometer = new LengthUtilities(dimensionInKilometer, UnitOfLength.Kilometer);

        boolean actual = measurementInCentimeter.equals(measurementInKilometer);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsTrueForOneThousandthKilometerEquals100Centimeter() throws IllegalArgumentException {
        double dimensionInCentimeter = 100;
        double dimensionInKilometer = 0.001;
        LengthUtilities measurementInCentimeter = new LengthUtilities(dimensionInCentimeter, UnitOfLength.Centimeter);
        LengthUtilities measurementInKilometer = new LengthUtilities(dimensionInKilometer, UnitOfLength.Kilometer);

        boolean actual = measurementInKilometer.equals(measurementInCentimeter);

        assertTrue(actual);
    }

    @Test
    public void testAddIs2MeterFor1MeterAnd100Centimeter() throws IllegalArgumentException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        LengthUtilities measurementInCentimeter = new LengthUtilities(dimensionInCentimeter, UnitOfLength.Centimeter);
        LengthUtilities measurementInMeter = new LengthUtilities(dimensionInMeter, UnitOfLength.Meter);
        LengthUtilities expected = new LengthUtilities(2, UnitOfLength.Meter);

        LengthUtilities actual = (LengthUtilities) measurementInMeter.add(measurementInCentimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testAddIs100200CentimeterFor200CentimeterAnd1Kilometer() throws IllegalArgumentException {
        double dimensionInCentimeter = 200;
        double dimensionInKilometer = 1;
        LengthUtilities measurementInCentimeter = new LengthUtilities(dimensionInCentimeter, UnitOfLength.Centimeter);
        LengthUtilities measurementInKilometer = new LengthUtilities(dimensionInKilometer, UnitOfLength.Kilometer);
        LengthUtilities expected = new LengthUtilities(100200, UnitOfLength.Centimeter);

        LengthUtilities actual = (LengthUtilities) measurementInKilometer.add(measurementInCentimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testAddIs2KilometerFor100000CentimeterAnd1000Meter() throws IllegalArgumentException {
        double dimensionInCentimeter = 100000;
        double dimensionInMeter = 1000;
        LengthUtilities measurementInCentimeter = new LengthUtilities(dimensionInCentimeter, UnitOfLength.Centimeter);
        LengthUtilities measurementInMeter = new LengthUtilities(dimensionInMeter, UnitOfLength.Meter);
        LengthUtilities expected = new LengthUtilities(2, UnitOfLength.Kilometer);

        LengthUtilities actual = (LengthUtilities) measurementInMeter.add(measurementInCentimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractIsHalfMeterForRemoving50CentimeterFrom1Meter() throws IllegalArgumentException {
        double dimensionInCentimeter = 50;
        double dimensionInMeter = 1;
        LengthUtilities measurementInCentimeter = new LengthUtilities(dimensionInCentimeter, UnitOfLength.Centimeter);
        LengthUtilities measurementInMeter = new LengthUtilities(dimensionInMeter, UnitOfLength.Meter);
        LengthUtilities expected = new LengthUtilities(0.5, UnitOfLength.Meter);

        LengthUtilities actual = (LengthUtilities) measurementInMeter.subtract(measurementInCentimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractIs1900CentimeterForRemoving1MeterFrom2000Centimeter() throws IllegalArgumentException {
        double dimensionInCentimeter = 2000;
        double dimensionInMeter = 1;
        LengthUtilities measurementInCentimeter = new LengthUtilities(dimensionInCentimeter, UnitOfLength.Centimeter);
        LengthUtilities measurementInMeter = new LengthUtilities(dimensionInMeter, UnitOfLength.Meter);
        LengthUtilities expected = new LengthUtilities(1900, UnitOfLength.Centimeter);

        LengthUtilities actual = (LengthUtilities) measurementInCentimeter.subtract(measurementInMeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractThrowsExceptionForRemoving1MeterFrom50Centimeter() throws IllegalArgumentException {
        double dimensionInCentimeter = 50;
        double dimensionInMeter = 1;
        LengthUtilities measurementInCentimeter = new LengthUtilities(dimensionInCentimeter, UnitOfLength.Centimeter);
        LengthUtilities measurementInMeter = new LengthUtilities(dimensionInMeter, UnitOfLength.Meter);

        assertThrows(IllegalArgumentException.class, () -> measurementInCentimeter.subtract(measurementInMeter));
    }

    @Test
    public void testSubtractThrowsExceptionForRemoving1MeterFrom1Meter() throws IllegalArgumentException {
        double dimensionInMeter = 1;
        LengthUtilities measurementInMeter = new LengthUtilities(dimensionInMeter, UnitOfLength.Meter);

        assertThrows(IllegalArgumentException.class, () -> measurementInMeter.subtract(measurementInMeter));
    }

}
