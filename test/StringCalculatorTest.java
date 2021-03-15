import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * String Calcaultor Tests 
 */
public class StringCalculatorTest {

    private StringCalculator calculator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void initialize() {
        calculator = new StringCalculator();
    }

    @Test
    public void emptyStringShouldReturn0() {
        assertEquals(calculator.add(""), 0);
    }

    @Test
    public void numberStringShouldReturnSameNumber() {
        assertEquals(calculator.add("1"), 1);
        assertEquals(calculator.add("5"), 5);
    }  
    
    @Test
    public void additionOfNumbersWithComma() {
        assertEquals(calculator.add("1,2"), 3);
        assertEquals(25, calculator.add("10,15"));
    }
    
    @Test
    public void additionOfNumbersWithNewLine() {
        assertEquals(calculator.add("1\n2"), 3);
        assertEquals(calculator.add("11\n13"), 24);
    }
    
    @Test
    public void exceptionWithNegativeInput() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("negative input!");
        calculator.add("-1");
        calculator.add("-5,10\n-15");
    }
}
