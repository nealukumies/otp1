package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    private TextField temperatureField = new TextField();
    private ComboBox<String> temperatureBox = new ComboBox<>();
    private Label resultLabel = new Label();
    private double fahrenheit;
    private double celsius;
    private double kelvin;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        List <String> temperatures = List.of("Celsius", "Fahrenheit", "Kelvin");
        temperatureBox.getItems().addAll(temperatures);
        temperatureBox.setCellFactory(lv -> new ListCell<String>(){
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item);
            }
        });

        temperatureField.setPromptText("Enter temperature");

        Button convertButton = new Button("Convert");

        convertButton.setOnAction(e -> {
            String fromTemperature = temperatureBox.getValue();
            convertTemperature(fromTemperature);
        });

        Button saveButton = new Button("Save to DB");
        saveButton.setOnAction(e -> Database.saveTemperature(celsius, fahrenheit, kelvin, resultLabel));

        HBox inputBox = new HBox(10, temperatureField, temperatureBox);
        VBox root = new VBox(10, inputBox, convertButton, resultLabel, saveButton);
        Scene scene = new Scene(root, 300, 200);

        stage.setTitle("Temperature Converter");
        stage.setScene(scene);
        stage.show();
    }

    private void convertTemperature(String fromTemperature) {
        TemperatureConverter converter = new TemperatureConverter();
        switch (fromTemperature) {
            case "Fahrenheit" -> {
                try {
                    fahrenheit = Double.parseDouble(temperatureField.getText());
                    celsius = converter.fahrenheitToCelsius(fahrenheit);
                    kelvin = converter.celsiusToKelvin(celsius);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input!");
                }
            }
            case "Kelvin" -> {
                try {
                    kelvin = Double.parseDouble(temperatureField.getText());
                    celsius = converter.kelvinToCelsius(kelvin);
                    fahrenheit = converter.celsiusToFahrenheit(celsius);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input!");
                }
        } case "Celsius" -> {
                try {
                    celsius = Double.parseDouble(temperatureField.getText());
                    fahrenheit = converter.celsiusToFahrenheit(celsius);
                    kelvin = converter.celsiusToKelvin(celsius);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input!");
                }
            }
            default -> resultLabel.setText("Select a temperature scale!");
        }
        resultLabel.setText(String.format("Celsius: %.2f, Fahrenheit: %.2f, Kelvin: %.2f", celsius, fahrenheit, kelvin));
    }
}