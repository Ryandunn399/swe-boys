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

    // (true for button clicked)
    // converted
    // Fahrenheit to be > 0
    // Celsius to be > 0

    // (True, Convert, > 0, > 0)
    @Test
    public void testCaseOne() {
        String fValue = "12";
        String cValue = "5";

        String expectedC = "-11.11";
        String expectedF = "41.0";

        driver.setFahrenheitValue(fValue);
        driver.setCelsiusValue(cValue);

        driver.convertClick();

        assertEquals(driver.getCelsiusValue(), expectedC);
        assertEquals(driver.getFahrenheitValue(), expectedF);
    }
}
