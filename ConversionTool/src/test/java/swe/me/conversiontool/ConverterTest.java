package swe.me.conversiontool;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnit test file for testing Converter.java
 */
public class ConverterTest {

    private static final float DELTA = 0.001f;

    /**
     * Conversion tool instance used for the tests.
     */
    ConversionTool cov;

    /**
     * This function is a prefix to all the tests in this class.
     */
    @Before
    public void setup() {
        cov = new ConversionTool();
    }

    /**
     * This function is a postfix to all the tests in this class.
     */
    @After
    public void cleanup() {
        cov = null;
    }

    /**
     * This test is primarily concerned with software observability.
     * We are controlling the inputs and attempting to observe the behavior
     * of the function.
     */
    @Test
    public void testIsNumeric() {
        assertTrue(cov.isNumeric("0.13"));
        assertTrue(cov.isNumeric("-1.0"));
        assertTrue(cov.isNumeric("0"));
        assertFalse(cov.isNumeric("1.2ab"));
        assertFalse(cov.isNumeric("String cheese"));
    }

    /**
     * This test is primarily concerned with software observability.
     * We are controlling the inputs and attempting to observe the behavior
     * of the function.
     */
    @Test
    public void testConvertToFloat() {
        float valueOne = 10.0f;
        float valueTwo = 3.14159f;
        float valueThree = 0.5f;
        float valueFour = -20.123f;

        assertEquals(valueOne, cov.convToFloat("10.0") ,DELTA);
        assertEquals(valueTwo, cov.convToFloat("3.14159"), DELTA);
        assertEquals(valueThree, cov.convToFloat("0.5"), DELTA);
        assertEquals(valueFour, cov.convToFloat("-20.123"), DELTA);
    }

    /**
     * This test is primarily concerned with software observability.
     * We are controlling the inputs and attempting to observe the behavior
     * of the function.
     *
     * This test in particular anticipates the result of erroneous
     * input to be a thrown error.
     */
    @Test(expected = NumberFormatException.class)
    public void testConvertToFloatError() {
        float value = cov.convToFloat("String cheese");
        assert(value == value);
    }

    /**
     * This test is primarily concerned with software observability.
     * We are controlling the inputs and attempting to observe the behavior
     * of the function.
     */
    @Test
    public void testConvertF2C () {
        float expectedOne = ((10 - 32.0f) * 5.0f) / 9.0f;
        float expectedTwo = ((-10 - 32.0f) * 5.0f) / 9.0f;
        float expectedThree = ((0 - 32.0f) * 5.0f) / 9.0f;

        assertEquals(expectedOne, cov.convertF2C("10"), DELTA);
        assertEquals(expectedTwo, cov.convertF2C("-10"), DELTA);
        assertEquals(expectedThree, cov.convertF2C("0"), DELTA);
    }

    /**
     * This test is primarily concerned with software observability.
     * We are controlling the inputs and attempting to observe the behavior
     * of the function.
     */
    @Test
    public void testConvertC2F () {
        float expectedOne = (10 * 9.0f / 5.0f) + 32.0f;
        float expectedTwo = (-10 * 9.0f / 5.0f) + 32.0f;
        float expectedThree = (0 * 9.0f / 5.0f) + 32.0f;

        assertEquals(expectedOne, cov.convertC2F("10"), DELTA);
        assertEquals(expectedTwo, cov.convertC2F("-10"), DELTA);
        assertEquals(expectedThree, cov.convertC2F("0"), DELTA);
    }

    /**
     * This test is primarily concerned with software observability.
     * We are controlling the inputs and attempting to observe the behavior
     * of the function.
     */
    @Test
    public void testConvertCm2In () {
        float expectedOne = 10.0f * 2.54f;
        float expectedTwo = -10.0f * 2.54f;
        float expectedThree = 0.0f * 2.54f;

        assertEquals(expectedOne, cov.convertIn2Cm("10"), DELTA);
        assertEquals(expectedTwo, cov.convertIn2Cm("-10"), DELTA);
        assertEquals(expectedThree, cov.convertIn2Cm("0"), DELTA);
    }

    /**
     * This test is primarily concerned with software observability.
     * We are controlling the inputs and attempting to observe the behavior
     * of the function.
     */
    @Test
    public void testConvertIn2Cm () {
        float expectedOne = 10.0f * 0.3937f;
        float expectedTwo = -10.0f * 0.3937f;
        float expectedThree = 0.0f * 0.3937f;

        assertEquals(expectedOne, cov.convertCm2In("10"), DELTA);
        assertEquals(expectedTwo, cov.convertCm2In("-10"), DELTA);
        assertEquals(expectedThree, cov.convertCm2In("0"), DELTA);
    }

    /**
     * This test is primarily concerned with software observability.
     * We are controlling the inputs and attempting to observe the behavior
     * of the function.
     */
    @Test
    public void testConvertF2M () {
        float expectedOne = 10.0f * 0.3048f;
        float expectedTwo = -10.0f * 0.3048f;
        float expectedThree = 0.0f * 0.3048f;

        assertEquals(expectedOne, cov.convertF2M("10"), DELTA);
        assertEquals(expectedTwo, cov.convertF2M("-10"), DELTA);
        assertEquals(expectedThree, cov.convertF2M("0"), DELTA);
    }

    /**
     * This test is primarily concerned with software observability.
     * We are controlling the inputs and attempting to observe the behavior
     * of the function.
     */
    @Test
    public void testConvertM2F () {
        float expectedOne = 10.0f / 0.3048f;
        float expectedTwo = -10.0f / 0.3048f;
        float expectedThree = 0.0f / 0.3048f;

        assertEquals(expectedOne, cov.convertM2F("10"), DELTA);
        assertEquals(expectedTwo, cov.convertM2F("-10"), DELTA);
        assertEquals(expectedThree, cov.convertM2F("0"), DELTA);
    }

    /**
     * This test is primarily concerned with software observability.
     * We are controlling the inputs and attempting to observe the behavior
     * of the function.
     */
    @Test
    public void testConvertM2K () {
        float expectedOne = 10.0f * 1.609f;
        float expectedTwo = -10.0f * 1.609f;
        float expectedThree = 0.0f * 1.609f;

        assertEquals(expectedOne, cov.convertM2K("10"), DELTA);
        assertEquals(expectedTwo, cov.convertM2K("-10"), DELTA);
        assertEquals(expectedThree, cov.convertM2K("0"), DELTA);
    }

    /**
     * This test is primarily concerned with software observability.
     * We are controlling the inputs and attempting to observe the behavior
     * of the function.
     */
    @Test
    public void testConvertK2M () {
        float expectedOne = 10.0f * 0.6214f;
        float expectedTwo = -10.0f * 0.6214f;
        float expectedThree = 0.0f * 0.6214f;

        assertEquals(expectedOne, cov.convertK2M("10"), DELTA);
        assertEquals(expectedTwo, cov.convertK2M("-10"), DELTA);
        assertEquals(expectedThree, cov.convertK2M("0"), DELTA);
    }

    /**
     * This test is primarily concerned with software observability.
     * We are controlling the inputs and attempting to observe the behavior
     * of the function.
     */
    @Test
    public void testConvertG2L() {
        float expectedOne = 10.0f * 3.785f;
        float expectedTwo = -10.0f * 3.785f;
        float expectedThree = 0.0f * 3.785f;

        assertEquals(expectedOne, cov.convertG2L("10"), DELTA);
        assertEquals(expectedTwo, cov.convertG2L("-10"), DELTA);
        assertEquals(expectedThree, cov.convertG2L("0"), DELTA);
    }

    /**
     * This test is primarily concerned with software observability.
     * We are controlling the inputs and attempting to observe the behavior
     * of the function.
     */
    @Test
    public void testConvertL2G() {
        float expectedOne = 10.0f / 3.785f;
        float expectedTwo = -10.0f / 3.785f;
        float expectedThree = 0.0f / 3.785f;

        assertEquals(expectedOne, cov.convertL2G("10"), DELTA);
        assertEquals(expectedTwo, cov.convertL2G("-10"), DELTA);
        assertEquals(expectedThree, cov.convertL2G("0"), DELTA);
    }

    /**
     * This test is primarily concerned with software observability.
     * We are controlling the inputs and attempting to observe the behavior
     * of the function.
     */
    @Test
    public void testConvertOz2G() {
        float expectedOne = 10.0f * 28.35f;
        float expectedTwo = -10.0f * 28.35f;
        float expectedThree = 0.0f * 28.35f;

        assertEquals(expectedOne, cov.convertOz2G("10"), DELTA);
        assertEquals(expectedTwo, cov.convertOz2G("-10"), DELTA);
        assertEquals(expectedThree, cov.convertOz2G("0"), DELTA);
    }

    /**
     * This test is primarily concerned with software observability.
     * We are controlling the inputs and attempting to observe the behavior
     * of the function.
     */
    @Test
    public void testConvertG2Oz() {
        float expectedOne = 10.0f / 28.35f;
        float expectedTwo = -10.0f / 28.35f;
        float expectedThree = 0.0f / 28.35f;

        assertEquals(expectedOne, cov.convertG2Oz("10"), DELTA);
        assertEquals(expectedTwo, cov.convertG2Oz("-10"), DELTA);
        assertEquals(expectedThree, cov.convertG2Oz("0"), DELTA);
    }

    /**
     * This test is primarily concerned with software observability.
     * We are controlling the inputs and attempting to observe the behavior
     * of the function.
     */
    @Test
    public void testConvertLb2K() {
        float expectedOne = 10.0f * 0.4536f;
        float expectedTwo = -10.0f * 0.4536f;
        float expectedThree = 0.0f * 0.4536f;

        assertEquals(expectedOne, cov.convertLb2K("10"), DELTA);
        assertEquals(expectedTwo, cov.convertLb2K("-10"), DELTA);
        assertEquals(expectedThree, cov.convertLb2K("0"), DELTA);
    }

    /**
     * This test is primarily concerned with software observability.
     * We are controlling the inputs and attempting to observe the behavior
     * of the function.
     */
    @Test
    public void testConvertK2Lb() {
        float expectedOne = 10.0f * 2.205f;
        float expectedTwo = -10.0f * 2.205f;
        float expectedThree = 0.0f * 2.205f;

        assertEquals(expectedOne, cov.convertK2Lb("10"), DELTA);
        assertEquals(expectedTwo, cov.convertK2Lb("-10"), DELTA);
        assertEquals(expectedThree, cov.convertK2Lb("0"), DELTA);
    }

    /**
     * This test is primarily concerned with software observability.
     * We are controlling the inputs and attempting to observe the behavior
     * of the function.
     */
    @Test
    public void testConvertHr2Min() {
        float expectedOne = 10.0f * 60.0f;
        float expectedTwo = -10.0f * 60.0f;
        float expectedThree = 0.0f * 60.0f;

        assertEquals(expectedOne, cov.convertHr2Min("10"), DELTA);
        assertEquals(expectedTwo, cov.convertHr2Min("-10"), DELTA);
        assertEquals(expectedThree, cov.convertHr2Min("0"), DELTA);
    }

    /**
     * This test is primarily concerned with software observability.
     * We are controlling the inputs and attempting to observe the behavior
     * of the function.
     */
    @Test
    public void testConvertMin2Hr() {
        float expectedOne = 10.0f / 60.0f;
        float expectedTwo = -10.0f / 60.0f;
        float expectedThree = 0.0f / 60.0f;

        assertEquals(expectedOne, cov.convertMin2Hr("10"), DELTA);
        assertEquals(expectedTwo, cov.convertMin2Hr("-10"), DELTA);
        assertEquals(expectedThree, cov.convertMin2Hr("0"), DELTA);
    }

    /**
     * These series of tests address the software controllability
     * of the program. Each of the following methods relies on other
     * pieces of software to work in conjunction with one another. The observability
     * of the parts that make up the controllable portions of these methods are tested
     * previously.
     * Test convert() -> controls method calls to correct conversion methods specified by user.
     * Test to ensure correct conversion method is called for given metric.
     */
    @Test
    public void testConvert() {
        float expectedF2C = (100.0f - 32.0f) * (5.0f / 9.0f);
        float expectedL2G = 30.0f / 3.785f;
        float expectedIn2Cm = 12.0f * 2.54f;
        float expectedHr2Min = 55.0f * 60.0f;

        assertEquals(expectedF2C, cov.convert("100", "Fahrenheit"), DELTA);
        assertEquals(expectedL2G, cov.convert("30", "Liters"), DELTA);
        assertEquals(expectedIn2Cm, cov.convert("12", "Inches"), DELTA);
        assertEquals(expectedHr2Min, cov.convert("55", "Hours"), DELTA);
    }

    /**
     * Test retrieveOutput() -> controls the number of decimal places (*with rounding nearest)
     * specified by user. Test to ensure output format corresponds with decimal places specified by user.
     */
    @Test
    public void testRetrieveOutput() {
        float testValue = 20.05381f;
        String expected0 = "20";
        String expected1 = "20.1";
        String expected2 = "20.05";
        String expected3 = "20.054";
        String expected4 = "20.0538";

        assertEquals(expected0, cov.retrieveOutput(testValue, 0));
        assertEquals(expected1, cov.retrieveOutput(testValue, 1));
        assertEquals(expected2, cov.retrieveOutput(testValue, 2));
        assertEquals(expected3, cov.retrieveOutput(testValue, 3));
        assertEquals(expected4, cov.retrieveOutput(testValue, 4));
    }

    /**
     * Will test one value for converting mph to kph.
     */
    @Test
    public void testMultipleMphToKph() {
        final float kphValueOne = 1.60934f;
        final float kphValueTwo = 3.21869f;

        assertEquals(kphValueOne, cov.convertMphToKph("1"), DELTA);
        assertEquals(kphValueTwo, cov.convertMphToKph("2"), DELTA);
    }

    @Test
    public void testOptionsValues() {
        assertTrue(cov.getStringOptions().contains("MPH"));
        assertTrue(cov.getStringOptions().contains("KPH"));
    }
}