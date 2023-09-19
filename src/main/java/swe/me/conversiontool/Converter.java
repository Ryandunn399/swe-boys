package swe.me.conversiontool;

/**
 * Class contains the various available conversion methods.
 */
public class Converter {

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
    public float convertHrToMin (String hours) {
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
    public float convertMinToHr (String mins) {
        float num1, num2;
        num1 = convToFloat(mins);
        num2 = num1 / 60.0f;
        return num2;
    }

    /**
     * Will convert a string value to float.
     *
     * @param metric string representation we are converting to a float.
     * @return the float value of the passed string.
     */
    private float convToFloat(String metric){
        return Float.parseFloat(metric);
    }

}
