// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 3
// JUnit for Thermostat.java
//
// NOT COMPLETE (SEPT 2014)

import org.junit.*;
import org.swebois.eleven.DayType;
import org.swebois.eleven.Period;
import org.swebois.eleven.ProgrammedSettings;
import org.swebois.eleven.Thermostat;

import static org.junit.Assert.*;

public class ThermostatTest
{
    private Thermostat thermo;
    private ProgrammedSettings settings;

    @Before // Set up - Called before every test method.
    public void setUp()
    {
        thermo   = new Thermostat();
        settings = new ProgrammedSettings();
        thermo.setThresholdDiff (1);
    }

    // if (((curTemp < dTemp - thresholdDiff) || (Override && curTemp < overTemp - thresholdDiff)) && (timeSinceLastRun > minLag))
    // Predicate: (a || (b && c)) && d

    @Test public void testTTTT()
    {
        settings.setSetting (Period.MORNING, DayType.WEEKDAY, 70);
        thermo.setPeriod (Period.MORNING);
        thermo.setDay (DayType.WEEKDAY);
        thermo.setCurrentTemp (68);
        thermo.setTimeSinceLastRun (10);
        thermo.setMinLag (5);
        thermo.setOverride (true);
        thermo.setOverTemp (72);
        assertTrue (thermo.turnHeaterOn (settings));
    }

    @Test public void testFFFF()
    {
        settings.setSetting (Period.MORNING, DayType.WEEKDAY, 70);
        thermo.setPeriod (Period.MORNING);
        thermo.setDay (DayType.WEEKDAY);
        thermo.setCurrentTemp (70);
        thermo.setTimeSinceLastRun (7);
        thermo.setMinLag (7);
        thermo.setOverride (false);
        thermo.setOverTemp (70);
        assertFalse (thermo.turnHeaterOn (settings));
    }

    @Test public void testPCtrue()
    {
        // Partial test for method turnHeaterOn() in class Thermostat
        // Criterion: PC
        // Value: True
        // Predicate: lines 28-30
        // Expected Output: true

        // Instantiate needed objects
        thermo   = new Thermostat();
        settings = new ProgrammedSettings();
        // Setting internal variable dTemp
        settings.setSetting (Period.MORNING, DayType.WEEKDAY, 69);
        thermo.setPeriod (Period.MORNING);
        thermo.setDay (DayType.WEEKDAY);
        // Clause a: curTemp < dTemp - thresholdDiff : true
        thermo.setCurrentTemp (63);
        thermo.setThresholdDiff (5);
        // Clause b: Override : true
        thermo.setOverride (true);
        // Clause c: curTemp < overTemp - thresholdDiff : true
        thermo.setOverTemp (70);
        // Clause d: timeSinceLastRun.greaterThan (minLag) : true
        thermo.setMinLag (10);
        thermo.setTimeSinceLastRun (12);
        // Run the test
        assertTrue (thermo.turnHeaterOn (settings));
    }

    //////////////////////////////////////////////////////////
    //              START OF ASSIGNMENT ELEVEN              //
    //////////////////////////////////////////////////////////

    // Override is b and regulator is not even a part of the predicate above
    // as a result, even though the assignment states we don't need to add any tests
    // that might have already been implemented for CACC we need to essentially
    // create a test for each scenario (TT, TF, FT) since the regulator value is never
    // assigned or used

    @Test
    public void testTT() {
        int curTemp = 68;
        int overTemp = 72;
        int expected = (curTemp - overTemp) / 2;
        // We can copy the test from TTTT to ensure reachability of lines
        // we are trying to test.
        settings.setSetting (Period.MORNING, DayType.WEEKDAY, 70);
        thermo.setPeriod (Period.MORNING);
        thermo.setDay (DayType.WEEKDAY);
        thermo.setCurrentTemp (curTemp);
        thermo.setTimeSinceLastRun (10);
        thermo.setMinLag (5);
        thermo.setOverride (true);
        thermo.setOverTemp (overTemp);
        thermo.setRegulator(true);
        thermo.turnHeaterOn(settings);

        assertEquals(expected, thermo.getRunTime());
    }

    @Test
    public void testTF() {
        int curTemp = 68;
        int overTemp = 72;

        // we expect the if else to branch two lines after the predicate we are testing
        int expected = curTemp - overTemp;
        // We can copy the test from TTTT to ensure reachability of lines
        // we are trying to test.
        settings.setSetting (Period.MORNING, DayType.WEEKDAY, 70);
        thermo.setPeriod (Period.MORNING);
        thermo.setDay (DayType.WEEKDAY);
        thermo.setCurrentTemp (curTemp);
        thermo.setTimeSinceLastRun (10);
        thermo.setMinLag (5);
        thermo.setOverride (true);
        thermo.setOverTemp (overTemp);
        thermo.setRegulator(false);
        thermo.turnHeaterOn(settings);

        assertEquals(expected, thermo.getRunTime());
    }

    @Test
    public void testFT() {
        int curTemp = 68;
        // We can copy the test from TTTT to ensure reachability of lines
        // we are trying to test.
        settings.setSetting (Period.MORNING, DayType.WEEKDAY, 70);
        thermo.setPeriod (Period.MORNING);
        thermo.setDay (DayType.WEEKDAY);
        thermo.setCurrentTemp (curTemp);
        thermo.setTimeSinceLastRun (10);
        thermo.setMinLag (5);
        thermo.setOverride (false);
        thermo.setRegulator(true);
        thermo.turnHeaterOn(settings);

        int dTemp = settings.getSetting(Period.MORNING, DayType.WEEKDAY);
        int expected = curTemp - dTemp;

        assertEquals(expected, thermo.getRunTime());
    }
}