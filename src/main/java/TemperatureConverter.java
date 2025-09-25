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

    public static void main(String[] args) {
        TemperatureConverter converter = new TemperatureConverter();
        double tempF = 100.0;
        double tempC = converter.fahrenheitToCelsius(tempF);
        System.out.println(tempF + "°F is " + tempC + "°C");

        tempC = 37.0;
        tempF = converter.celsiusToFahrenheit(tempC);
        System.out.println(tempC + "°C is " + tempF + "°F");

        double extremeTemp = -45.0;
        System.out.println(extremeTemp + "°C is extreme: " + converter.isExtreme(extremeTemp));

        double kelvinTemp = 300.0;
        double celsiusTemp = converter.kelvinToCelsius(kelvinTemp);
        System.out.println(kelvinTemp + "K is " + celsiusTemp + "°C");
    }

}
