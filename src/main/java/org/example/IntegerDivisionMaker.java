package org.example;

public class IntegerDivisionMaker {
    public IntegerDivisorData make(int divisor, int dividend) {
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

        int[] digits = numberToArray(divisor);

        int minuend = 0;
        int multiple , subtrahend, different;

        for (int i = 0; i < digits.length; i++) {
            minuend = minuend * 10 + digits[i];
            if (minuend < dividend) {
                data.setQuotient(data.getQuotient() * 10);
            } else {
                multiple = minuend / dividend;
                subtrahend = dividend * multiple;
                different = minuend - subtrahend;

                data.getItemDivisions().add(new StepDivisor(minuend,subtrahend,different));

                minuend  = different;

                data.setQuotient(data.getQuotient() * 10 + multiple);
            }
        }

        data.setRemainder(minuend);

        if ((divisor > 0 && dividend < 0) || (divisor < 0 && dividend > 0)) {
            data.setQuotient(-data.getQuotient());
        }

        return data;
    }

    public int[] numberToArray(int number) {
        int countOfDivisorDigits = 0;
        int temp = number;
        while (temp != 0) {
            temp /= 10;
            countOfDivisorDigits++;
        }

        int[] digits = new int[countOfDivisorDigits];

        for (int i = 0, lastIndex = digits.length - 1; i < digits.length-1; i++, lastIndex--) {
            int tenPow = (int) Math.pow(10, lastIndex);
            digits[i] = number / tenPow;
            number %= tenPow;
        }

        digits[digits.length-1] = number % 10;

        return digits;
    }
}