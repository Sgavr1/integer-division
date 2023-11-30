package org.example;

import java.util.List;

public class PrintDataIntegerDivisor {
    public void print(IntegerDivisorData data){

        int countDigitsDivisor = (int) Math.log10(data.getDivisor()) + 1;
        int countDigitsDividend = (int) Math.log10(data.getDividend()) + 1;
        int countDigitsQuotient = (int) Math.log10(data.getQuotient()) + 1;

        if (data.getItemDivisions().size() == 0) {
            System.out.println(data.getDivisor() + "|" + data.getDividend());
            System.out.println(" ".repeat(countDigitsDivisor) + "|" + "-".repeat(countDigitsDividend));
            System.out.println(" ".repeat(countDigitsDivisor) + "|0");
            return;
        }


        ItemDivisor item = data.getItemDivisions().get(0);
        int countDigitsSubtrahend = (int) Math.log10(item.getSubtrahend()) + 1;

        System.out.println("_" + data.getDivisor() + "|" + data.getDividend());
        System.out.print(" " + item.getSubtrahend() + " ".repeat(countDigitsDivisor - countDigitsSubtrahend) + "|");

        if (data.getDividend() > data.getQuotient()) {
            System.out.println("-".repeat(countDigitsDividend));
        } else {
            System.out.println("-".repeat(countDigitsQuotient));
        }

        System.out.println(" " + "-".repeat(countDigitsSubtrahend) + " ".repeat(countDigitsDivisor - countDigitsSubtrahend) + "|" + data.getQuotient());

        for (int i = 1; i< data.getItemDivisions().size(); i++) {
            item = data.getItemDivisions().get(i);
            countDigitsSubtrahend = (int) Math.log10(item.getSubtrahend()) + 1;

            System.out.println(" ".repeat(i) + "_" + item.getMinuend());
            System.out.println(" ".repeat(i + 1) + item.getSubtrahend());

            if (item.getSubtrahend() == 0) {
                countDigitsSubtrahend = 1;
            }

            System.out.println(" ".repeat(i + 1) + "-".repeat(countDigitsSubtrahend));
        }


        if (data.getRemainder() == 0) {
            System.out.println(" ".repeat(data.getItemDivisions().size()) + data.getRemainder());
        } else {
            int countDigitsRemainder = (int) Math.log10(data.getRemainder()) + 1;
            System.out.println(" ".repeat(data.getItemDivisions().size() + countDigitsSubtrahend - countDigitsRemainder) + data.getRemainder());
        }


    }
}
