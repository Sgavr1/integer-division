package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerDivisionPrinterTest {

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenParameterIsNull(){
        IntegerDivisionPrinter integerDivisionPrinter = new IntegerDivisionPrinter();

        assertThrows(IllegalArgumentException.class, () -> {
            integerDivisionPrinter.print(null);
        });
    }

    @Test
    public void shouldReturnStringIntegerDivisionWhenCorrectParameter(){
        IntegerDivisionPrinter integerDivisionPrinter = new IntegerDivisionPrinter();
        IntegerDivisionMaker integerDivisionMaker = new IntegerDivisionMaker();

        String stringIntegerDivision = "_125|25\n";
        stringIntegerDivision += " 125|-\n";
        stringIntegerDivision += " -  |5\n";
        stringIntegerDivision += " 0\n";

        assertEquals(stringIntegerDivision, integerDivisionPrinter.print(integerDivisionMaker.make(125,25)));
    }
}