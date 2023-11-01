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

    // (false, convert, f = 0, c = 0)
    @Test
    public void testCaseOne() {
        String fvalue = "0";
        String cvalue = "0";

        String expectedFValue = "";
        String expectedCValue = "";

        driver.setFahrenheitValue(fvalue);
        driver.setCelsiusValue(cValue);

        assertEquals(driver.getFahrenheitValue(), expectedFValue);
        assertEquals(driver.getCelsiusValue(), expectedCValue);
    }
    // (true, clear, f = 0, c = 0)
    @Test
    public void testCaseTwo() {
        String fvalue = "0";
        String cvalue = "0";

        String expectedFValue = "";
        String expectedCValue = "";

        driver.setFahrenheitValue(fvalue);
        driver.setCelsiusValue(cValue);

        driver.clearClick();

        assertEquals(driver.getFahrenheitValue(), expectedFValue);
        assertEquals(driver.getCelsiusValue(), expectedCValue);
    }
    // (true, convert, f > 0, c = 0)
    @Test
    public void testCaseThree() {
        String fvalue = "15";
        String cvalue = "0";

        String expectedFValue = "32.0";
        String expectedCValue = "-9.44";

        driver.setFahrenheitValue(fvalue);
        driver.setCelsiusValue(cValue);

        driver.convertClick();

        assertEquals(driver.getFahrenheitValue(), expectedFValue);
        assertEquals(driver.getCelsiusValue(), expectedCValue);
    }
    // (true, convert, f < 0, c = 0)
    @Test
    public void testCaseFour() {
        String fvalue = "-20";
        String cvalue = "0";

        String expectedFValue = "32.0";
        String expectedCValue = "-28.89";

        driver.setFahrenheitValue(fvalue);
        driver.setCelsiusValue(cValue);

        driver.convertClick();

        assertEquals(driver.getFahrenheitValue(), expectedFValue);
        assertEquals(driver.getCelsiusValue(), expectedCValue);
    }
    // (true, convert, f is empty, c = 0)
    @Test
    public void testCaseFive() {
        String fvalue = "";
        String cvalue = "0";

        String expectedFValue = "32";
        String expectedCValue = "";

        driver.setFahrenheitValue(fvalue);
        driver.setCelsiusValue(cValue);

        driver.convertClick();

        assertEquals(driver.getFahrenheitValue(), expectedFValue);
        assertEquals(driver.getCelsiusValue(), expectedCValue);
    }
    // (true, convert, f = 0, c > 0)
    @Test
    public void testCaseSix() {
        String fvalue = "0";
        String cvalue = "28";

        String expectedFValue = "82.4";
        String expectedCValue = "-17.78";

        driver.setFahrenheitValue(fvalue);
        driver.setCelsiusValue(cValue);

        driver.convertClick();

        assertEquals(driver.getFahrenheitValue(), expectedFValue);
        assertEquals(driver.getCelsiusValue(), expectedCValue);
    }
    // (true, convert, f = 0, c < 0)
    @Test
    public void testCaseSeven() {
        String fvalue = "0";
        String cvalue = "-23";

        String expectedFValue = "-9.4";
        String expectedCValue = "-17.78";

        driver.setFahrenheitValue(fvalue);
        driver.setCelsiusValue(cValue);

        driver.convertClick();

        assertEquals(driver.getFahrenheitValue(), expectedFValue);
        assertEquals(driver.getCelsiusValue(), expectedCValue);
    }
    // (true, convert, f = 0, c is empty)
    @Test
    public void testCaseEight() {
        String fvalue = "0";
        String cvalue = ;

        String expectedFValue = "";
        String expectedCValue = "-17.78";

        driver.setFahrenheitValue(fvalue);
        driver.setCelsiusValue(cValue);

        driver.convertClick();

        assertEquals(driver.getFahrenheitValue(), expectedFValue);
        assertEquals(driver.getCelsiusValue(), expectedCValue);
    }
}
