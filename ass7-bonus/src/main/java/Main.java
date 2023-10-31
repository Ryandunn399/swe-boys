public class Main {

    public static void main(String[] args) throws Exception {

        CalculatorWebDriver driver = new CalculatorWebDriver();

        driver.setFahrenheitValue("5");

        driver.convertClick();

        System.out.println(driver.getCelsiusValue());
    }
}
