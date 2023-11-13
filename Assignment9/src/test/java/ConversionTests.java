import me.swe437.assign9.Conversion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConversionTests {

    public Conversion c;
    public HttpServletRequest req;
    public HttpServletResponse res;

    @Before
    public void setup() {
        this.c = new Conversion();
        this.req = mock(HttpServletRequest.class);
        this.res = mock(HttpServletResponse.class);
    }

    @After
    public void destroy() {
        this.c = null;
        this.req = mock(HttpServletRequest.class);
        this.res = mock(HttpServletResponse.class);
    }

    /**
     * Test the first path where we expect all values to be null.
     */
    @Test
    public void testPathOne() throws IOException, ServletException {
        StringWriter writer = new StringWriter();
        PrintWriter out = new PrintWriter(writer);

        // Don't set any parameter.

        when(res.getWriter()).thenReturn(out);

        c.doPost(req, res);

        assertEquals(getTestOneOracle(), writer.toString());
    }

    /**
     * Test path two were we are trying to trigger every if branch.
     */
    @Test
    public void testPathTwo() throws IOException, ServletException {
        StringWriter writer = new StringWriter();
        PrintWriter out = new PrintWriter(writer);
        when(req.getParameter("F")).thenReturn("1");
        when(req.getParameter("C")).thenReturn("1");
        when(req.getParameter("in")).thenReturn("1");
        when(req.getParameter("cm")).thenReturn("1");
        when(req.getParameter("ft")).thenReturn("1");
        when(req.getParameter("m")).thenReturn("1");
        when(req.getParameter("mi")).thenReturn("1");
        when(req.getParameter("km")).thenReturn("1");
        when(req.getParameter("gal")).thenReturn("1");
        when(req.getParameter("L")).thenReturn("1");
        when(req.getParameter("oz")).thenReturn("1");
        when(req.getParameter("g")).thenReturn("1");
        when(req.getParameter("lb")).thenReturn("1");
        when(req.getParameter("kg")).thenReturn("1");
        when(res.getWriter()).thenReturn(out);

        c.doPost(req, res);

        assertEquals(getTestTwoOracle(), writer.toString());
    }

    public String getTestOneOracle() {
        StringWriter writer = new StringWriter();
        PrintWriter out = new PrintWriter(writer);
        out.println ("<html>");
        out.println ("<head>");
        out.println ("<title>Measurement units conversion</title>");
        out.println (" <script language=\"JavaScript\">");
        out.println ("");
        out.println (" <!--");
        out.println (" // Function borrowed from Thilo Rusche");
        out.println (" function ClearForm()");
        out.println (" {  // Set all the form values to blank.");
        out.println ("    var form = document.forms[0];");
        out.println ("    for (i=0; i < form.elements.length; i++)");
        out.println ("    {");
        out.println ("       if (form.elements[i].name != \"submit\" &&");
        out.println ("           form.elements[i].name != \"clear\")");
        out.println ("           form.elements[i].value = \"\";");
        out.println ("  }");
        out.println ("  return false;");
        out.println (" }");
        out.println (" //-->");
        out.println (" </script>");
        out.println ("</head>");
        out.println ("<body>");
        out.println ("<center><h2>On-line Measurement Conversion</h2></center>");
        out.println ("Jeff Offutt and Ren Li");
        out.println ("<hr>");
        out.print   ("<form method=\"post\"");
        out.println (" action=\"https://cs.gmu.edu:8443/offutt/servlet/conversion\">");
        out.println (" <p>");
        out.println (" <table cellspacing=0 cellpadding=5 border=0");
        out.print   ("  align=center>");
        out.println (" <tr align=right>");
        out.print   ("  <td><b>Fahrenheit  (F&#186;):</b> ");
        out.print   ("  <input type=\"text\" name=\"F\" size=6 value=\"");
        out.println ("\"></td>");
        out.println ("  <td><-----></td>");
        out.println ("  <td><b>Celsius (C&#186;):</b> ");
        out.print   ("  <input type=\"text\" name=\"C\" size=6 value=\"");
        out.println ("\"></td>");
        out.println (" <tr align=right>");
        out.println ("  <td><b>Inch (in):</b> ");
        out.print   ("  <input type=\"text\" name=\"in\" size=6 value=\"");
        out.println ("\"></td>");
        out.println ("  <td><-----></td>");
        out.println ("  <td><b>Centimeter (cm):</b> ");
        out.print   ("  <input type=\"text\" name=\"cm\" size=6 value=\"");
        out.println ("\"></td>");
        out.println (" <tr align=right>");
        out.println ("  <td><b>Feet (ft):</b> ");
        out.print   ("  <input type=\"text\" name=\"ft\" size=6 value=\"");
        out.println ("\"></td>");
        out.println ("  <td><-----></td>");
        out.println ("  <td><b>Meter (m):</b> ");
        out.print   ("  <input type=\"text\" name=\"m\" size=6 value=\"");
        out.println ("\"></td>");
        out.println (" <tr align=right>");
        out.println ("  <td><b>Mile (mi):</b> ");
        out.print   ("  <input type=\"text\" name=\"mi\" size=6 value=\"");
        out.println ("\"></td>");
        out.println ("  <td><-----></td>");
        out.println ("  <td><b>Kilometer (km):</b> ");
        out.print   ("  <inpUt type=\"text\" name=\"km\" size=6 value=\"");
        out.println ("\"></td>");
        out.println (" <tr align=right>");
        out.println ("  <td><b>Gallon (gal):</b> ");
        out.print   ("  <input type=\"text\" name=\"gal\" size=6 value=\"");
        out.println ("\"></td>");
        out.println ("  <td><-----></td>");
        out.println ("  <td><b>Liter (L):</b> ");
        out.print   ("  <input type=\"text\" name=\"L\" size=6 value=\"");
        out.println ("\"></td>");
        out.println (" <tr align=right>");
        out.println ("  <td><b>Ounce (oz):</b> ");
        out.print   ("  <input type=\"text\" name=\"oz\" size=6 value=\"");
        out.println ("\"></td>");
        out.println ("  <td><-----></td>");
        out.println ("  <td><b>Gram (g):</b> ");
        out.print   ("  <input type=\"text\" name=\"g\" size=6 value=\"");
        out.println ("\"></td>");
        out.println (" <tr align=right>");
        out.println ("  <td><b>Pound (lb):</b> ");
        out.print   ("  <input type=\"text\" name=\"lb\" size=6 value=\"");
        out.println ("\"></td>");
        out.println ("  <td><-----></td>");
        out.println ("  <td><b>Kilogram (kg):</b> ");
        out.print   ("  <input type=\"text\" name=\"kg\" size=6 value=\"");
        out.println ("\"></td>");
        out.println (" </table>");
        out.print   (" <table cellspacing=0 cellpadding=10");
        out.println ("   BORDER=0 ALIGN=center WIDTH=\"50%\">");
        out.println ("  <tr align=center>");
        out.println ("   <td><input name=\"submit\" type=\"submit\" value=\"Convert\"></td>");
        out.println ("   <td><input name=\"clear\" type=\"button\" value=\"Clear Form\"");
        out.println ("              onClick=\"ClearForm()\"></td>");
        out.println ("  </tr>");
        out.println (" </table>");
        out.println ("</form>");
        out.println ("<p>");
        out.println ("<hr>");
        out.println ("</body>");
        out.println ("</html>");
        return writer.toString();
    }

    public static String getTestTwoOracle() {
        StringWriter writer = new StringWriter();
        PrintWriter out = new PrintWriter(writer);
        out.println ("<html>");
        out.println ("<head>");
        out.println ("<title>Measurement units conversion</title>");
        out.println (" <script language=\"JavaScript\">");
        out.println ("");
        out.println (" <!--");
        out.println (" // Function borrowed from Thilo Rusche");
        out.println (" function ClearForm()");
        out.println (" {  // Set all the form values to blank.");
        out.println ("    var form = document.forms[0];");
        out.println ("    for (i=0; i < form.elements.length; i++)");
        out.println ("    {");
        out.println ("       if (form.elements[i].name != \"submit\" &&");
        out.println ("           form.elements[i].name != \"clear\")");
        out.println ("           form.elements[i].value = \"\";");
        out.println ("  }");
        out.println ("  return false;");
        out.println (" }");
        out.println (" //-->");
        out.println (" </script>");
        out.println ("</head>");
        out.println ("<body>");
        out.println ("<center><h2>On-line Measurement Conversion</h2></center>");
        out.println ("Jeff Offutt and Ren Li");
        out.println ("<hr>");
        out.print   ("<form method=\"post\"");
        out.println (" action=\"https://cs.gmu.edu:8443/offutt/servlet/conversion\">");
        out.println (" <p>");
        out.println (" <table cellspacing=0 cellpadding=5 border=0");
        out.print   ("  align=center>");
        out.println (" <tr align=right>");
        out.print   ("  <td><b>Fahrenheit  (F&#186;):</b> ");
        out.print   ("  <input type=\"text\" name=\"F\" size=6 value=\"33.8");
        out.println ("\"></td>");
        out.println ("  <td><-----></td>");
        out.println ("  <td><b>Celsius (C&#186;):</b> ");
        out.print   ("  <input type=\"text\" name=\"C\" size=6 value=\"-17.22");
        out.println ("\"></td>");
        out.println (" <tr align=right>");
        out.println ("  <td><b>Inch (in):</b> ");
        out.print   ("  <input type=\"text\" name=\"in\" size=6 value=\"0.39");
        out.println ("\"></td>");
        out.println ("  <td><-----></td>");
        out.println ("  <td><b>Centimeter (cm):</b> ");
        out.print   ("  <input type=\"text\" name=\"cm\" size=6 value=\"2.54");
        out.println ("\"></td>");
        out.println (" <tr align=right>");
        out.println ("  <td><b>Feet (ft):</b> ");
        out.print   ("  <input type=\"text\" name=\"ft\" size=6 value=\"3.28");
        out.println ("\"></td>");
        out.println ("  <td><-----></td>");
        out.println ("  <td><b>Meter (m):</b> ");
        out.print   ("  <input type=\"text\" name=\"m\" size=6 value=\"0.3");
        out.println ("\"></td>");
        out.println (" <tr align=right>");
        out.println ("  <td><b>Mile (mi):</b> ");
        out.print   ("  <input type=\"text\" name=\"mi\" size=6 value=\"0.62");
        out.println ("\"></td>");
        out.println ("  <td><-----></td>");
        out.println ("  <td><b>Kilometer (km):</b> ");
        out.print   ("  <inpUt type=\"text\" name=\"km\" size=6 value=\"1.61");
        out.println ("\"></td>");
        out.println (" <tr align=right>");
        out.println ("  <td><b>Gallon (gal):</b> ");
        out.print   ("  <input type=\"text\" name=\"gal\" size=6 value=\"0.26");
        out.println ("\"></td>");
        out.println ("  <td><-----></td>");
        out.println ("  <td><b>Liter (L):</b> ");
        out.print   ("  <input type=\"text\" name=\"L\" size=6 value=\"3.79");
        out.println ("\"></td>");
        out.println (" <tr align=right>");
        out.println ("  <td><b>Ounce (oz):</b> ");
        out.print   ("  <input type=\"text\" name=\"oz\" size=6 value=\"0.04");
        out.println ("\"></td>");
        out.println ("  <td><-----></td>");
        out.println ("  <td><b>Gram (g):</b> ");
        out.print   ("  <input type=\"text\" name=\"g\" size=6 value=\"28.35");
        out.println ("\"></td>");
        out.println (" <tr align=right>");
        out.println ("  <td><b>Pound (lb):</b> ");
        out.print   ("  <input type=\"text\" name=\"lb\" size=6 value=\"2.21");
        out.println ("\"></td>");
        out.println ("  <td><-----></td>");
        out.println ("  <td><b>Kilogram (kg):</b> ");
        out.print   ("  <input type=\"text\" name=\"kg\" size=6 value=\"0.45");
        out.println ("\"></td>");
        out.println (" </table>");
        out.print   (" <table cellspacing=0 cellpadding=10");
        out.println ("   BORDER=0 ALIGN=center WIDTH=\"50%\">");
        out.println ("  <tr align=center>");
        out.println ("   <td><input name=\"submit\" type=\"submit\" value=\"Convert\"></td>");
        out.println ("   <td><input name=\"clear\" type=\"button\" value=\"Clear Form\"");
        out.println ("              onClick=\"ClearForm()\"></td>");
        out.println ("  </tr>");
        out.println (" </table>");
        out.println ("</form>");
        out.println ("<p>");
        out.println ("<hr>");
        out.println ("</body>");
        out.println ("</html>");
        return writer.toString();
    }
}
