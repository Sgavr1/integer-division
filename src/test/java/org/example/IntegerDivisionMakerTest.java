package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerDivisionMakerTest {

    @ParameterizedTest
    @CsvSource({"0,15", "15,0"})
    public void shouldThrowArithmeticExceptionIfDivisionOrDividendEquals0(int division, int dividend) {
        IntegerDivisionMaker integerDivisionMaker = new IntegerDivisionMaker();

        assertThrows(ArithmeticException.class, ()-> {
            integerDivisionMaker.make(division,dividend);
        });
    }

    @Test
    public void shouldReturnZeroWhenDivisionLessDividend() {
        IntegerDivisionMaker integerDivisionMaker = new IntegerDivisionMaker();

        IntegerDivisorData data = integerDivisionMaker.make(15,100);

        assertEquals(15, data.getDivisor());
        assertEquals(100, data.getDividend());
        assertEquals(0, data.getQuotient());
        assertEquals(15, data.getRemainder());
    }

    @ParameterizedTest
    @CsvSource({"125, 25, 5, 0, 125, 125, 0" , "128, 16, 8, 0, 128, 128, 0"})
    public void shouldReturnCorrectDivisionWhenCorrectDivisionAndDividend(int divisor, int dividend, int quotient, int remainder, int minuend, int subtrahend, int difference) {
        IntegerDivisionMaker integerDivisionMaker = new IntegerDivisionMaker();

        IntegerDivisorData data = integerDivisionMaker.make(divisor,dividend);

        assertEquals(divisor, data.getDivisor());
        assertEquals(dividend, data.getDividend());
        assertEquals(quotient, data.getQuotient());
        assertEquals(remainder, data.getRemainder());

        StepDivisor stepDivisor = data.getItemDivisions().get(0);

        assertEquals(minuend, stepDivisor.getMinuend());
        assertEquals(subtrahend, stepDivisor.getSubtrahend());
        assertEquals(difference, stepDivisor.getDifference());
    }
}