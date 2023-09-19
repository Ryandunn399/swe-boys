package swe.me.conversiontool;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ConversionTool extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        Label inputLabel = new Label("Input value:");
        gridPane.add(inputLabel, 0, 0);

        TextField inputField = new TextField();
        gridPane.add(inputField, 1, 0);

        ArrayList<String> convertOptions = new ArrayList<>();
        convertOptions.add("Fahrenheit");
        convertOptions.add("Celsius");
        convertOptions.add("Inches");
        convertOptions.add("Centimeters");
        convertOptions.add("Feet");
        convertOptions.add("Meters");
        convertOptions.add("Miles");
        convertOptions.add("Kilometers");
        convertOptions.add("Gallons");
        convertOptions.add("Liters");
        convertOptions.add("Ounces");
        convertOptions.add("Grams");
        convertOptions.add("Pounds");
        convertOptions.add("Kilograms");
        convertOptions.add("Hours");
        convertOptions.add("Minutes");

        ArrayList<String> decimalOptions = new ArrayList<>();
        decimalOptions.add("0");
        decimalOptions.add("1");
        decimalOptions.add("2");
        decimalOptions.add("3");
        decimalOptions.add("4");

        // Setup the dropdown menus for our available unit conversions
        Label fromLabel = new Label("From:");
        Label toLabel = new Label("To:");

        ComboBox<String> fromComboBox = new ComboBox<>();
        fromComboBox.getItems().addAll(convertOptions);
        fromComboBox.setValue("Fahrenheit");

        ComboBox<String> toComboBox = new ComboBox<>();
        toComboBox.getItems().addAll(convertOptions);
        toComboBox.setValue("Celsius");

        // Establish event listeners for when a change is made
        // in one of the dropdown menus
        fromComboBox.setOnAction(actionEvent -> {
            String val = fromComboBox.getValue();
            handleDropdownChange(val, toComboBox);
        });

        toComboBox.setOnAction(actionEvent -> {
            String val = toComboBox.getValue();
            handleDropdownChange(val, fromComboBox);
        });

        // Add the drop-down boxes to our pane
        gridPane.add(fromLabel, 0, 1);
        gridPane.add(fromComboBox, 1, 1);
        gridPane.add(toLabel, 0, 2);
        gridPane.add(toComboBox, 1, 2);

        // Create decimal field
        Label decimalLabel = new Label("Decimals:");

        ComboBox<String> decimalBox = new ComboBox<>();
        decimalBox.getItems().addAll(decimalOptions);
        decimalBox.setValue("0");

        gridPane.add(decimalLabel, 0, 3);
        gridPane.add(decimalBox, 1, 3);

        // Set up the output text field
        Label outputLabel = new Label("Output value:");
        gridPane.add(outputLabel, 0, 4);

        TextField outputField = new TextField();
        outputField.setEditable(false);
        gridPane.add(outputField, 1, 4);

        // Create the convert button and establish the event handler
        Button convertButton = new Button("Convert");

        convertButton.setOnAction(actionEvent -> {
            // Retrieve input value
            String inputVal = inputField.getText();

            if (inputVal == null || inputVal.equals("") || !isNumeric(inputVal)) {
                inputVal = "0.0";
                inputField.setText(inputVal);
            }

            String fromSystem = fromComboBox.getValue();

            int numDecimal = Integer.parseInt(decimalBox.getValue());

            float convertedVal = convert(inputVal, fromSystem);
            String outputVal = retrieveOutput(convertedVal, numDecimal);

            outputField.setText(outputVal);
        });

        gridPane.add(convertButton, 1, 5);

        Scene scene = new Scene(gridPane, 400, 250);
        stage.setTitle("Conversion Tool");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Determine the necessary decimal values based on the value passed in the num decimals field.
     *
     * @param numDecimal the number of decimals
     * @return the correctly formatted string value.
     */
    private String retrieveOutput(float val, int numDecimal) {
        return switch (numDecimal) {
            case 0 -> String.format("%d", (int) val);
            case 1 -> String.format("%.1f", val);
            case 2 -> String.format("%.2f", val);
            case 3 -> String.format("%.3f", val);
            case 4 -> String.format("%.4f", val);
            default -> null;
        };
    }

    /**
     * Method to handle the actual conversion of an input based on the value
     * and the corresponding system we are converting  from.  Since each
     * value is directly mapped 1-to-1 we only need to know the from value
     * to know what value we are supposed to convert to.
     *
     * @param value the value we are converting.
     * @param systemFrom the system we are converting from.
     * @return the value of the system we need to convert to.
     */
    private float convert(String value, String systemFrom) {

        Converter converter = new Converter();
        float returnVal = 0.0f;

        if (systemFrom == null)
            return -1.0f;

        // Fahrenheit to celsius
        if (systemFrom.equalsIgnoreCase("Fahrenheit")) {
            returnVal = converter.convertF2C(value);
        }

        // Celsius to fahrenheit
        if (systemFrom.equalsIgnoreCase("Celsius")){
            returnVal = converter.convertC2F(value);
        }

        // Inches to centimeters
        if (systemFrom.equalsIgnoreCase("Inches")) {
            returnVal = converter.convertIn2Cm(value);
        }

        // Centimeters to inches
        if (systemFrom.equalsIgnoreCase("Centimeters")){
            returnVal = converter.convertCm2In(value);
        }

        // Feet to meters
        if (systemFrom.equalsIgnoreCase("Feet")) {
            returnVal = converter.convertF2M(value);
        }

        // Meters to feet
        if (systemFrom.equalsIgnoreCase("Meters")){
            returnVal = converter.convertM2F(value);
        }

        // Miles to kilometers
        if (systemFrom.equalsIgnoreCase("Miles")) {
            returnVal = converter.convertM2K(value);
        }

        // Kilometers to miles
        if (systemFrom.equalsIgnoreCase("Kilometers")){
            returnVal = converter.convertK2M(value);
        }

        // Gallons to liters
        if (systemFrom.equalsIgnoreCase("Gallons")) {
            returnVal = converter.convertG2L(value);
        }

        // Liters to gallons
        if (systemFrom.equalsIgnoreCase("Liters")){
            returnVal = converter.convertK2M(value);
        }

        // Ounces to grams
        if (systemFrom.equalsIgnoreCase("Ounces")) {
            returnVal = converter.convertOz2G(value);
        }

        // Grams to ounces
        if (systemFrom.equalsIgnoreCase("Grams")){
            returnVal = converter.convertG2Oz(value);
        }

        // Pounds to kilograms
        if (systemFrom.equalsIgnoreCase("Pounds")) {
            returnVal = converter.convertLb2K(value);
        }

        // Kilograms to pounds
        if (systemFrom.equalsIgnoreCase("Kilograms")){
            returnVal = converter.convertK2Lb(value);
        }

        // Hours to minutes
        if (systemFrom.equalsIgnoreCase("Hours")) {
            returnVal = converter.convertHrToMin(value);
        }

        // Minutes to hours
        if (systemFrom.equalsIgnoreCase("Minutes")){
            returnVal = converter.convertMinToHr(value);
        }

        return returnVal;
    }

    /**
     * Method for changing drown down menu based on current string
     * value.
     *
     * @param value the value of the dropdown box.
     * @param otherBox the other dropdown box we are going to change.
     */
    private void handleDropdownChange(String value, ComboBox<String> otherBox) {

        if (value.equalsIgnoreCase("Fahrenheit")) {
            otherBox.setValue("Celsius");
            return;
        }

        if (value.equalsIgnoreCase("Celsius")) {
            otherBox.setValue("Fahrenheit");
            return;
        }

        if (value.equalsIgnoreCase("Inches")) {
            otherBox.setValue("Centimeters");
            return;
        }

        if (value.equalsIgnoreCase("Centimeters")) {
            otherBox.setValue("Inches");
            return;
        }

        if (value.equalsIgnoreCase("Feet")) {
            otherBox.setValue("Meters");
            return;
        }

        if (value.equalsIgnoreCase("Meters")) {
            otherBox.setValue("Feet");
            return;
        }

        if (value.equalsIgnoreCase("Miles")) {
            otherBox.setValue("Kilometers");
            return;
        }

        if (value.equalsIgnoreCase("Kilometers")) {
            otherBox.setValue("Miles");
            return;
        }

        if (value.equalsIgnoreCase("Gallons")) {
            otherBox.setValue("Liters");
            return;
        }

        if (value.equalsIgnoreCase("Liters")) {
            otherBox.setValue("Gallons");
            return;
        }

        if (value.equalsIgnoreCase("Ounces")) {
            otherBox.setValue("Grams");
            return;
        }

        if (value.equalsIgnoreCase("Grams")) {
            otherBox.setValue("Ounces");
            return;
        }

        if (value.equalsIgnoreCase("Pounds")) {
            otherBox.setValue("Kilograms");
            return;
        }

        if (value.equalsIgnoreCase("Kilograms")) {
            otherBox.setValue("Pounds");
        }

        if (value.equalsIgnoreCase("Hours")) {
            otherBox.setValue("Minutes");
            return;
        }

        if (value.equalsIgnoreCase("Minutes")) {
            otherBox.setValue("Hours");
        }
    }

    /**
     * Helper method to determine whether or not a value is numeric.
     *
     * @param val the string value we are checking
     * @return true if the value is numeric, or false if it is not.
     */
    private boolean isNumeric(String val) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        if (val == null)
            return false;

        return pattern.matcher(val).matches();
    }

    public static void main(String[] args) {
        launch();
    }
}