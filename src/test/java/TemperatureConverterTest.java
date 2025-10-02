import main.TemperatureConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//Test by Nea Lukumies
class TemperatureConverterTest {
    TemperatureConverter temperatureConverter = new TemperatureConverter();
    private static final double DELTA = 0.01;
    @Test
    void fahrenheitToCelsius() {
        assertEquals(0,temperatureConverter.fahrenheitToCelsius(32), DELTA);
        assertEquals(-14.92,temperatureConverter.fahrenheitToCelsius(5.15), DELTA);
        assertEquals(54.44,temperatureConverter.fahrenheitToCelsius(130), DELTA);
    }

    @Test
    void celsiusToFahrenheit() {
        assertEquals(32,temperatureConverter.celsiusToFahrenheit(0), DELTA);
        assertEquals(5.15,temperatureConverter.celsiusToFahrenheit(-14.92), DELTA);
        assertEquals(130,temperatureConverter.celsiusToFahrenheit(54.44), DELTA);
    }

    @Test
    void isExtreme() {
        assertTrue(temperatureConverter.isExtreme(-41));
        assertTrue(temperatureConverter.isExtreme(51));
        assertFalse(temperatureConverter.isExtreme(0));
    }

    @Test
    void kelvinToCelsius() {
        assertEquals(0,temperatureConverter.kelvinToCelsius(273.15), DELTA);
        assertEquals(-273.15,temperatureConverter.kelvinToCelsius(0), DELTA);
        assertEquals(100,temperatureConverter.kelvinToCelsius(373.15), DELTA);
    }
}