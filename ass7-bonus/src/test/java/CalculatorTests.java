import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTests {

    private CalculatorWebDriver driver;

    @Before
    public void setup() {
        driver = new CalculatorWebDriver();
    }

    @After
    public void cleanup() {
        driver.close();
    }

    // (true, convert, f = 0, c = 0)
    @Test
    public void testBaseCase() {
        String fValue = "0";
        String cValue = "0";

        String expectedFValue = "0";
        String expectedCValue = "0";

        driver.setFahrenheitValue(fValue);
        driver.setCelsiusValue(cValue);

        assertEquals(expectedFValue, driver.getFahrenheitValue());
        assertEquals(expectedCValue, driver.getCelsiusValue());

    }

    // (false, convert, f = 0, c = 0)
    @Test
    public void testCaseOne() {
        String fValue = "0";
        String cValue = "0";

        String expectedFValue = "0";
        String expectedCValue = "0";

        driver.setFahrenheitValue(fValue);
        driver.setCelsiusValue(cValue);

        assertEquals(expectedFValue, driver.getFahrenheitValue());
        assertEquals(expectedCValue, driver.getCelsiusValue());
    }

    // (true, clear, f = 0, c = 0)
    @Test
    public void testCaseTwo() {
        String fValue = "0";
        String cValue = "0";

        String expectedFValue = "";
        String expectedCValue = "";

        driver.setFahrenheitValue(fValue);
        driver.setCelsiusValue(cValue);

        driver.clearClick();

        assertEquals(expectedFValue, driver.getFahrenheitValue());
        assertEquals(expectedCValue, expectedCValue);
    }

    // (true, convert, f > 0, c = 0)
    @Test
    public void testCaseThree() {
        String fValue = "15";
        String cValue = "0";

        String expectedFValue = "32.0";
        String expectedCValue = "-9.44";

        driver.setFahrenheitValue(fValue);
        driver.setCelsiusValue(cValue);

        driver.convertClick();

        assertEquals(expectedFValue, driver.getFahrenheitValue());
        assertEquals(expectedCValue, driver.getCelsiusValue());
    }

    // (true, convert, f < 0, c = 0)
    @Test
    public void testCaseFour() {
        String fValue = "-20";
        String cValue = "0";

        String expectedFValue = "32.0";
        String expectedCValue = "-28.89";

        driver.setFahrenheitValue(fValue);
        driver.setCelsiusValue(cValue);

        driver.convertClick();

        assertEquals(expectedFValue, driver.getFahrenheitValue());
        assertEquals(expectedCValue, driver.getCelsiusValue());
    }

    // (true, convert, f is empty, c = 0)
    @Test
    public void testCaseFive() {
        String fValue = "";
        String cValue = "0";

        String expectedFValue = "32.0";
        String expectedCValue = "";

        driver.setFahrenheitValue(fValue);
        driver.setCelsiusValue(cValue);

        driver.convertClick();

        assertEquals(expectedFValue, driver.getFahrenheitValue());
        assertEquals(expectedCValue, driver.getCelsiusValue());
    }

    // (true, convert, f = 0, c > 0)
    @Test
    public void testCaseSix() {
        String fValue = "0";
        String cValue = "28";

        String expectedFValue = "82.4";
        String expectedCValue = "-17.78";

        driver.setFahrenheitValue(fValue);
        driver.setCelsiusValue(cValue);

        driver.convertClick();

        assertEquals(expectedFValue, driver.getFahrenheitValue());
        assertEquals(expectedCValue, driver.getCelsiusValue());
    }

    // (true, convert, f = 0, c < 0)
    @Test
    public void testCaseSeven() {
        String fValue = "0";
        String cValue = "-23";

        String expectedFValue = "-9.4";
        String expectedCValue = "-17.78";

        driver.setFahrenheitValue(fValue);
        driver.setCelsiusValue(cValue);

        driver.convertClick();

        assertEquals(expectedFValue, driver.getFahrenheitValue());
        assertEquals(expectedCValue, driver.getCelsiusValue());
    }

    // (true, convert, f = 0, c is empty)
    @Test
    public void testCaseEight() {
        String fValue = "0";
        String cValue = "";

        String expectedFValue = "";
        String expectedCValue = "-17.78";

        driver.setFahrenheitValue(fValue);
        driver.setCelsiusValue(cValue);

        driver.convertClick();

        assertEquals(expectedFValue, driver.getFahrenheitValue());
        assertEquals(expectedCValue, driver.getCelsiusValue());
    }
}
