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

    /**
     * Method used to build the grind pane for our JavaFX GUI as well as
     * assign the various event handlers for the components of the GUI.
     *
     * @return a grid pane instance to be utilized by the JavaFX scene
     */
    private GridPane buildGui() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        Label inputLabel = new Label("Input value:");
        gridPane.add(inputLabel, 0, 0);

        TextField inputField = new TextField();
        gridPane.add(inputField, 1, 0);

        ArrayList<String> convertOptions = getStringOptions();

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

            if (inputVal == null || inputVal.isEmpty() || !isNumeric(inputVal)) {
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

        return gridPane;
    }

    /**
     * Will build the list of available options present in our conversion program.
     *
     * @return A list of strings.
     */
    protected ArrayList<String> getStringOptions() {
        ArrayList<String> options = new ArrayList<>();

        options.add("Fahrenheit");
        options.add("Celsius");
        options.add("Inches");
        options.add("Centimeters");
        options.add("Feet");
        options.add("Meters");
        options.add("Miles");
        options.add("Kilometers");
        options.add("Gallons");
        options.add("Liters");
        options.add("Ounces");
        options.add("Grams");
        options.add("Pounds");
        options.add("Kilograms");
        options.add("Hours");
        options.add("Minutes");
        options.add("MPH");
        options.add("KPH");

        return options;
    }

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(buildGui(), 400, 250);
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
    protected String retrieveOutput(float val, int numDecimal) {
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
    public float convert(String value, String systemFrom) {

        if (systemFrom == null)
            return -1.0f;

        // Fahrenheit to celsius
        if (systemFrom.equalsIgnoreCase("Fahrenheit")) {
            return convertF2C(value);
        }

        // Celsius to fahrenheit
        if (systemFrom.equalsIgnoreCase("Celsius")){
            return convertC2F(value);
        }

        // Inches to centimeters
        if (systemFrom.equalsIgnoreCase("Inches")) {
            return convertIn2Cm(value);
        }

        // Centimeters to inches
        if (systemFrom.equalsIgnoreCase("Centimeters")){
            return convertCm2In(value);
        }

        // Feet to meters
        if (systemFrom.equalsIgnoreCase("Feet")) {
            return convertF2M(value);
        }

        // Meters to feet
        if (systemFrom.equalsIgnoreCase("Meters")){
            return convertM2F(value);
        }

        // Miles to kilometers
        if (systemFrom.equalsIgnoreCase("Miles")) {
            return convertM2K(value);
        }

        // Kilometers to miles
        if (systemFrom.equalsIgnoreCase("Kilometers")){
            return convertK2M(value);
        }

        // Gallons to liters
        if (systemFrom.equalsIgnoreCase("Gallons")) {
            return convertG2L(value);
        }

        // Liters to gallons
        if (systemFrom.equalsIgnoreCase("Liters")){
            return convertL2G(value);
        }

        // Ounces to grams
        if (systemFrom.equalsIgnoreCase("Ounces")) {
            return convertOz2G(value);
        }

        // Grams to ounces
        if (systemFrom.equalsIgnoreCase("Grams")){
            return convertG2Oz(value);
        }

        // Pounds to kilograms
        if (systemFrom.equalsIgnoreCase("Pounds")) {
            return convertLb2K(value);
        }

        // Kilograms to pounds
        if (systemFrom.equalsIgnoreCase("Kilograms")){
            return convertK2Lb(value);
        }

        // Hours to minutes
        if (systemFrom.equalsIgnoreCase("Hours")) {
            return convertHr2Min(value);
        }

        // Minutes to hours
        if (systemFrom.equalsIgnoreCase("Minutes")){
            return convertMin2Hr(value);
        }

        if (systemFrom.equalsIgnoreCase("MPH")) {
            return convertMphToKph(value);
        }

        return -1.0f;
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

        if (value.equalsIgnoreCase("MPH")) {
            otherBox.setValue("KPH");
        }

        if (value.equalsIgnoreCase("KPH")) {
            otherBox.setValue("MPH");
        }
    }

    /**
     * Helper method to determine whether or not a value is numeric.
     *
     * @param val the string value we are checking
     * @return true if the value is numeric, or false if it is not.
     */
    protected boolean isNumeric(String val) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        if (val == null)
            return false;

        return pattern.matcher(val).matches();
    }

    /**
     * Will convert fahrenheit to celsius.
     *
     * @param FAsStr float value represented by a string.
     * @return converted celsius value as a float
     */
    public float convertF2C (String FAsStr) {
        float num1, num2;
        num1 = convToFloat(FAsStr);
        num2 = ((num1-32.0f) * 5.0f) / 9.0f;
        return num2;
    }

    /**
     * Will convert celsius to fahrenheit.
     *
     * @param CAsStr float value represented by a string.
     * @return converted fahrenheit value as a float
     */
    public float convertC2F (String CAsStr) {
        float num1, num2;
        num1 = convToFloat(CAsStr);
        num2 = (num1 * 9.0f / 5.0f) + 32.0f;
        return num2;
    }

    /**
     * Will convert inches to centimeters.
     *
     * @param inAsStr float value represented by a string.
     * @return converted centimeters value as a float.
     */
    public float convertIn2Cm (String inAsStr) {
        float num1, num2;
        num1 = convToFloat(inAsStr);
        num2 = num1 * 2.54f;
        return num2;
    }

    /**
     * Will convert centimeters to inches.
     *
     * @param cmAsStr float value represented by a string.
     * @return converted inches value as a float.
     */
    public float convertCm2In (String cmAsStr) {
        float num1, num2;
        num1 = convToFloat(cmAsStr);
        num2 = num1 * 0.3937f;
        return num2;
    }

    /**
     * Will convert feet to meters.
     *
     * @param ftAsStr float value represented by a string.
     * @return converted meters value as a float.
     */
    public float convertF2M (String ftAsStr) {
        float num1, num2;
        num1 = convToFloat(ftAsStr);
        num2 = num1 * 0.3048f;
        return num2;
    }

    /**
     * Will convert meters to feet.
     *
     * @param mAsStr float value represented by a string.
     * @return converted feet value as a float.
     */
    public float convertM2F (String mAsStr) {
        float num1, num2;
        num1 = convToFloat(mAsStr);
        num2 = num1 / 0.3048f;
        return num2;
    }

    /**
     * Will convert miles to kilometers.
     *
     * @param miAsStr float value represented by a string.
     * @return converted kilometers value as a float.
     */
    public float convertM2K (String miAsStr) {
        float num1, num2;
        num1 = convToFloat(miAsStr);
        num2 = num1 * 1.609f;
        return num2;
    }

    /**
     * Will convert kilometers to miles.
     *
     * @param kmAsStr float value represented by a string.
     * @return converted miles value as a float.
     */
    public float convertK2M (String kmAsStr) {
        float num1, num2;
        num1 = convToFloat(kmAsStr);
        num2 = num1 * 0.6214f;
        return num2;
    }

    /**
     * Will convert gallons to liters.
     *
     * @param galAsStr float value represented by a string.
     * @return converted liters value as a float.
     */
    public float convertG2L (String galAsStr) {
        float num1, num2;
        num1 = convToFloat(galAsStr);
        num2 = num1 * 3.785f;
        return num2;
    }

    /**
     * Will convert liters to gallons.
     *
     * @param LAsStr float value represented by a string.
     * @return converted gallons value as a float.
     */
    public float convertL2G (String LAsStr) {
        float num1, num2;
        num1 = convToFloat(LAsStr);
        num2 = num1 / 3.785f;
        return num2;
    }

    /**
     * Will convert ounces to grams.
     *
     * @param ozAsStr float value represented by a string.
     * @return converted grams value as a float.
     */
    public float convertOz2G (String ozAsStr) {
        float num1, num2;
        num1 = convToFloat(ozAsStr);
        num2 = num1 * 28.35f;
        return num2;
    }

    /**
     * Will convert grams to ounces.
     *
     * @param gAsStr float value represented by a string.
     * @return converted ounces value as a float.
     */
    public float convertG2Oz (String gAsStr) {
        float num1, num2;
        num1 = convToFloat(gAsStr);
        num2 = num1 / 28.35f;
        return num2;
    }

    /**
     * Will convert pounds to kilograms.
     *
     * @param lbAsStr float value represented by a string.
     * @return converted kilograms value as a float.
     */
    public float convertLb2K (String lbAsStr) {
        float num1, num2;
        num1 = convToFloat(lbAsStr);
        num2 = num1 * 0.4536f;
        return num2;
    }

    /**
     * Will convert kilograms to pounds.
     *
     * @param kgAsStr float value represented by a string.
     * @return converted pounds value as a float.
     */
    public float convertK2Lb (String kgAsStr) {
        float num1, num2;
        num1 = convToFloat(kgAsStr);
        num2 = num1 * 2.205f;
        return num2;
    }

    /**
     * Will convert hours to minutes.
     *
     * @param hours float value represented by a string.
     * @return converted minutes value as a float.
     */
    public float convertHr2Min(String hours) {
        float num1, num2;
        num1 = convToFloat(hours);
        num2 = num1 * 60.0f;
        return num2;
    }

    /**
     * Will convert minutes to hours.
     *
     * @param mins float value represented by a string.
     * @return converted hours value as a float.
     */
    public float convertMin2Hr(String mins) {
        float num1, num2;
        num1 = convToFloat(mins);
        num2 = num1 / 60.0f;
        return num2;
    }

    /**
     * Method for converting miles per hour to kilometers per hour.
     *
     * @param val miles per hour float value.
     * @return kilometers per hour float value.
     */
    public float convertMphToKph(String kph) {
        return (convToFloat(kph) * 1.60934f);
    }

    /**
     * Will convert a string value to float.
     *
     * @param metric string representation we are converting to a float.
     * @return the float value of the passed string.
     */
    protected float convToFloat(String metric){
        return Float.parseFloat(metric);
    }

    public static void main(String[] args) {
        launch();
    }
}