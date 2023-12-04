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
            integerDivisionMaker.division(division,dividend);
        });
    }

    @Test
    public void shouldReturnZeroWhenDivisionLessDividend() {
        IntegerDivisionMaker integerDivisionMaker = new IntegerDivisionMaker();

        IntegerDivisorData data = new IntegerDivisorData();

        data.setDivisor(100);
        data.setDividend(101);
        data.setQuotient(0);
        data.setRemainder(100);

        assertEquals(data, integerDivisionMaker.division(100,101));
    }

    @Test
    public void shouldReturnFiveWhenDivision125Dividend25() {
        IntegerDivisionMaker integerDivisionMaker = new IntegerDivisionMaker();

        IntegerDivisorData data = new IntegerDivisorData();

        data.setDivisor(125);
        data.setDividend(25);
        data.setQuotient(5);
        data.setRemainder(0);

        data.getItemDivisions().add(new StepDivisor(125,125,0));

        assertEquals(data, integerDivisionMaker.division(125,25));
    }

    @Test
    public void shouldReturnEightWhenDivision128Dividend16() {
        IntegerDivisionMaker integerDivisionMaker = new IntegerDivisionMaker();

        IntegerDivisorData data = new IntegerDivisorData();

        data.setDivisor(128);
        data.setDividend(16);
        data.setQuotient(8);
        data.setRemainder(0);

        data.getItemDivisions().add(new StepDivisor(128,128,0));

        assertEquals(data, integerDivisionMaker.division(128,16));
    }
}