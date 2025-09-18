public class TemperatureConverter {

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9;
    }

    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    public boolean isExtreme(double temperature) {
        return temperature < -40 || temperature > 50;
    }

    public double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

}
