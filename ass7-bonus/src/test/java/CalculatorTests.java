import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Before;

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
}
