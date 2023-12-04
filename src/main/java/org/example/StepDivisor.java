package org.example;

public class StepDivisor {
    private int minuend;
    private int subtrahend;
    private int difference;

    public StepDivisor(int minuend, int subtrahend, int difference) {
        this.minuend = minuend;
        this.subtrahend = subtrahend;
        this.difference = difference;
    }

    public int getMinuend() {
        return minuend;
    }

    public int getSubtrahend() {
        return subtrahend;
    }

    public int getDifference() {
        return difference;
    }


    @Override
    public boolean equals(Object obj) {
        StepDivisor itemDivisor = (StepDivisor) obj;

        if (this.minuend == itemDivisor.getMinuend() && this.subtrahend == itemDivisor.getSubtrahend() && this.difference == itemDivisor.getDifference()) {
            return true;
        }

        return false;
    }
}
