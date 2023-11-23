package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerDivisionMakerTest {

    @ParameterizedTest
    @CsvSource({"0,15", "15,0"})
    public void shouldThrowArithmeticExceptionIfDivisionOrDividendEquals0(int division, int dividend){
        IntegerDivisionMaker integerDivisionMaker = new IntegerDivisionMaker();

        assertThrows(ArithmeticException.class, ()->{
            integerDivisionMaker.division(division,dividend);
        });
    }

    @Test
    public void shouldReturnZeroWhenDivisionLessDividend(){
        IntegerDivisionMaker integerDivisionMaker = new IntegerDivisionMaker();

        assertEquals(0, integerDivisionMaker.division(15,16));
    }

    @Test
    public void shouldReturnFiveWhenDivision125Dividend25(){
        IntegerDivisionMaker integerDivisionMaker = new IntegerDivisionMaker();

        assertEquals(5,integerDivisionMaker.division(125,25));
    }

    public void shouldReturnEightWhenDivision128Dividend16(){
        IntegerDivisionMaker integerDivisionMaker = new IntegerDivisionMaker();

        assertEquals(8, integerDivisionMaker.division(128,8));
    }
}