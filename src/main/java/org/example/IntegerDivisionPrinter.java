package org.example;

public class IntegerDivisionPrinter {
    public String print(IntegerDivisorData data) {

        if (data == null) {
            throw new IllegalArgumentException("Argument is null");
        }

        String stringDivisionInfo = printUpperPart(data);

        for (int i = 1; i<data.getItemDivisions().size(); i++) {
            StepDivisor step = data.getItemDivisions().get(i);

            stringDivisionInfo += printOneDivisionStep(data.getItemDivisions().get(i), i);
        }

        return stringDivisionInfo + " ".repeat(data.getItemDivisions().size()) + data.getRemainder() + "\n";
    }

    private String printUpperPart(IntegerDivisorData divisorData) {
        StepDivisor step = divisorData.getItemDivisions().get(0);

        int countOfQuotientDigits = (int) Math.log10(divisorData.getQuotient()) + 1;
        int countOfDivisorDigits = (int) Math.log10(divisorData.getDivisor()) + 1;
        int countOfSubtrahendDigits = (int) Math.log10(step.getSubtrahend()) + 1;

        String stringUpperPart = "_" + divisorData.getDivisor() + "|" + divisorData.getDividend() +"\n";
        stringUpperPart += " " + step.getSubtrahend() + " ".repeat(countOfDivisorDigits - countOfSubtrahendDigits) + "|" + "-".repeat(countOfQuotientDigits) +"\n";
        stringUpperPart += " -" + " ".repeat(countOfDivisorDigits - 1) + "|" + divisorData.getQuotient() + "\n";

        return stringUpperPart;
    }

    private String printOneDivisionStep(StepDivisor step, int padding){
        String stringOneDivisionStep = " ".repeat(padding) + "_" + step.getMinuend() + "\n";
        stringOneDivisionStep += " ".repeat(padding + 1) + step.getSubtrahend() + "\n";
        stringOneDivisionStep += " ".repeat(padding + 1) + "-\n";

        return stringOneDivisionStep;
    }
}
