import org.junit.jupiter.api.Test;

import javax.naming.LimitExceededException;

import static org.junit.jupiter.api.Assertions.*;


public class TemperatureTest {

    @Test
    public void testIf0CelsiusIsEqualTo32Fahrenheit() {
        double celsiusOfValue0 = 0;
        double fahrenheitOfValue32 = 32;
        TemperatureUtilties measurementInCelsius = new TemperatureUtilties(celsiusOfValue0, UnitOfTemperature.Celsius);
        TemperatureUtilties measurementInFahrenheit = new TemperatureUtilties(fahrenheitOfValue32, UnitOfTemperature.Fahrenheit);

        assertEquals(measurementInCelsius, measurementInFahrenheit);
    }

    @Test
    public void testIf32FahrenheitIsEqualTo0Celsius() {
        double celsiusOfValue0 = 0;
        double fahrenheitOfValue32 = 32;
        TemperatureUtilties measurementInCelsius = new TemperatureUtilties(celsiusOfValue0, UnitOfTemperature.Celsius);
        TemperatureUtilties measurementInFahrenheit = new TemperatureUtilties(fahrenheitOfValue32, UnitOfTemperature.Fahrenheit);

        assertEquals(measurementInCelsius, measurementInFahrenheit);
    }

    @Test
    public void testThrowsExceptionIfValueOfKelvinExceedsRange() {
        double kelvinInvalidValue = -15;

        assertThrows(IllegalArgumentException.class, () -> new TemperatureUtilties(kelvinInvalidValue, UnitOfTemperature.Kelvin));
    }

    @Test
    public void testThrowsExceptionIfValueOfCelsiusExceedsRange() {
        double celciusInvalidValue = -274.15;

        assertThrows(IllegalArgumentException.class, () -> new TemperatureUtilties(celciusInvalidValue, UnitOfTemperature.Celsius));
    }

    @Test
    public void testThrowsExceptionIfValueOfFahrenheitExceedsRange() {
        double fahrenheitInvalidValue = -460.67;

        assertThrows(IllegalArgumentException.class, () -> new TemperatureUtilties(fahrenheitInvalidValue, UnitOfTemperature.Fahrenheit));
    }

    @Test
    public void testIf32FahrenheitIsNotEqualTo1Celsius() throws LimitExceededException {
        double celsiusOfValue0 = 1;
        double fahrenheitOfValue32 = 32;
        TemperatureUtilties measurementInCelsius = new TemperatureUtilties(celsiusOfValue0, UnitOfTemperature.Celsius);
        TemperatureUtilties measurementInFahrenheit = new TemperatureUtilties(fahrenheitOfValue32, UnitOfTemperature.Fahrenheit);

        assertNotEquals(measurementInCelsius, measurementInFahrenheit);
    }

    @Test
    public void testIf0KelvinIsEqualToMinus273Celsius() throws LimitExceededException {
        double celsiusOfValueMinus273 = -273.15;
        double kelvinOfValue0 = 0;
        TemperatureUtilties measurementInCelsius = new TemperatureUtilties(celsiusOfValueMinus273, UnitOfTemperature.Celsius);
        TemperatureUtilties measurementInKelvin = new TemperatureUtilties(kelvinOfValue0, UnitOfTemperature.Kelvin);

        assertEquals(measurementInCelsius, measurementInKelvin);
    }

    @Test
    public void testIfMinus273CelsiusEqualTo0kelvin() {
        double celsiusOfValueMinus273 = -273.15;
        double kelvinOfValue0 = 0;
        TemperatureUtilties measurementInCelsius = new TemperatureUtilties(celsiusOfValueMinus273, UnitOfTemperature.Celsius);
        TemperatureUtilties measurementInKelvin = new TemperatureUtilties(kelvinOfValue0, UnitOfTemperature.Kelvin);

        assertEquals(measurementInCelsius, measurementInKelvin);
    }

}