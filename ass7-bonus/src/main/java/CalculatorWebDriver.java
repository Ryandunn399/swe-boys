import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * An overly OOP'd implementation of the Selenium methods we would need to
 * properly automate testing of the Calculator's functionality for assignment seven.
 */
public class CalculatorWebDriver {

    static final String URL = "https://cs.gmu.edu:8443/offutt/servlet/conversion";

    /**
     * This object will hold the input box for Fahrenheit.
     */
    private WebElement fElement;

    /**
     * This object will hold the input box for Celsius.
     */
    private WebElement cElement;

    /**
     * This object will hold the convert button element.
     */
    private WebElement convertBtn;

    /**
     * This object will hold our clear form button element.
     */
    private WebElement clearBtn;

    private WebDriver driver;

    /**
     * Class constructor. Will initialize a chrome driver.
     */
    public CalculatorWebDriver() {
        this.driver = new ChromeDriver();

        driver.get(URL);

        // Load our separate elements.
        fElement = driver.findElement(By.name("F"));
        cElement = driver.findElement(By.name("C"));

        convertBtn = driver.findElement(By.name("submit"));
        clearBtn = driver.findElement(By.name("clear"));
    }

    /**
     * Method should be used to close connection once we no longer need it.
     */
    public void close() {
        driver.close();
    }

    /**
     * Will set the text of the Fahrenheit input box.
     *
     * @param value the text we want to input.
     */
    public void setFahrenheitValue(String value) {
        try {
            fElement.sendKeys(value);
            return;
        } catch (StaleElementReferenceException e) {
            fElement = driver.findElement(By.name("F"));
        }

        fElement.sendKeys(value);
    }

    /**
     * Will set the text of the Celsius input box.
     *
     * @param value the text we want to input.
     */
    public void setCelsiusValue(String value) {
        try {
            cElement.sendKeys(value);
            return;
        } catch (StaleElementReferenceException e) {
            cElement = driver.findElement(By.name("C"));
        }

        cElement.sendKeys(value);
    }

    /**
     * Will retrieve the input value based on what's currently
     * inside the Fahrenheit input box.
     *
     * @return the text inside the Fahrenheit input box.
     */
    public String getFahrenheitValue() {
        try {
            return fElement.getAttribute("value");
        } catch (StaleElementReferenceException e) {
            fElement = driver.findElement(By.name("F"));
        }

        return fElement.getAttribute("value");
    }

    /**
     * Will retrieve the input value based on what's currently
     * inside the Celsius input box.
     *
     * @return the text inside the Celsius input box.
     */
    public String getCelsiusValue() {
        try {
            return cElement.getAttribute("value");
        } catch (StaleElementReferenceException e) {
            cElement = driver.findElement(By.name("C"));
        }

        return cElement.getAttribute("value");
    }

    /**
     * Will simulate clicking on the convert button.
     */
    public void convertClick() {
        try {
            convertBtn.click();
            return;
        } catch (StaleElementReferenceException e) {
            convertBtn = driver.findElement(By.name("submit"));
        }

        convertBtn.click();
    }

    /**
     * Will simulate clicking on the convert button.
     */
    public void clearClick() {
        try {
            clearBtn.click();
            return;
        } catch (StaleElementReferenceException e) {
            clearBtn = driver.findElement(By.name("clear"));
        }

        clearBtn.click();
    }
}