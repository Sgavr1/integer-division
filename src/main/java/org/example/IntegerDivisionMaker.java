package org.example;

public class IntegerDivisionMaker {
    public IntegerDivisorData division(int divisor, int dividend) {
        if (divisor == 0 || dividend == 0) {
            throw new ArithmeticException("Divisor on zero");
        }

        IntegerDivisorData data = new IntegerDivisorData();
        data.setDivisor(divisor);
        data.setDividend(dividend);
        data.setQuotient(0);

        if (divisor < dividend) {
            data.setRemainder(divisor);

            return data;
        }

        int countDigitDivisor = (int) Math.log10(Math.abs(divisor));

        int[] digits = new int[countDigitDivisor+1];

        int temp = divisor;

        for (int i = 0; i < digits.length-1; i++, countDigitDivisor--) {
            int tenPow = (int) Math.pow(10, countDigitDivisor);
            digits[i] = temp / tenPow;
            temp %= tenPow;
        }

        digits[digits.length - 1] = divisor % 10;

        int minuend = 0;
        int multiple , subtrahend, different;

        for (int i = 0; i < digits.length; i++) {
            minuend = minuend * 10 + digits[i];
            if (minuend >= dividend) {
                multiple = minuend / dividend;
                subtrahend = dividend * multiple;
                different = minuend - subtrahend;

                data.getItemDivisions().add(new ItemDivisor(minuend,subtrahend,different));

                minuend  = different;

                data.setQuotient(data.getQuotient() * 10 + multiple);
            } else if (minuend == 0) {
                data.getItemDivisions().add(new ItemDivisor(0,0,0));
                data.setQuotient(data.getQuotient() * 10);
            }
        }

        data.setRemainder(minuend);

        if ((divisor > 0 && dividend < 0) || (divisor < 0 && dividend > 0)) {
            data.setQuotient(-data.getQuotient());
        }

        return data;
    }
}
