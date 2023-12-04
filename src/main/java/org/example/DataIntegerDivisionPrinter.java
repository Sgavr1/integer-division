package org.example;

public class DataIntegerDivisionPrinter {
    public void print(IntegerDivisorData data) {
        StepDivisor step = data.getItemDivisions().get(0);

        int countOfDivisorDigits = (int) Math.log10(data.getDivisor()) + 1;
        int countOfQuotientDigits = (int) Math.log10(data.getQuotient()) + 1;
        int countOfSubtrahendDigits = (int) Math.log10(step.getSubtrahend()) + 1;

        System.out.println("_" + data.getDivisor() + "|" + data.getDividend());
        System.out.println(" " + step.getSubtrahend() + " ".repeat(countOfDivisorDigits - countOfSubtrahendDigits) + "|" + "-".repeat(countOfQuotientDigits));
        System.out.println(" -" + " ".repeat(countOfDivisorDigits - 1) + "|" + data.getQuotient());

        for (int i = 1; i<data.getItemDivisions().size(); i++) {
            step = data.getItemDivisions().get(i);

            System.out.println(" ".repeat(i) + "_" + step.getMinuend());
            System.out.println(" ".repeat(i + 1) + step.getSubtrahend());
            System.out.println(" ".repeat(i + 1) + "-");
        }

        System.out.println(" ".repeat(data.getItemDivisions().size()) + data.getRemainder());
    }
}
