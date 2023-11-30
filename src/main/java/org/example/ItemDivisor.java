package org.example;

public class ItemDivisor {
    private int minuend;
    private int subtrahend;
    private int difference;

    public ItemDivisor(int minuend, int subtrahend, int difference) {
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
        ItemDivisor itemDivisor = (ItemDivisor) obj;

        if (this.minuend == itemDivisor.getMinuend() && this.subtrahend == itemDivisor.getSubtrahend() && this.difference == itemDivisor.getDifference()) {
            return true;
        }

        return false;
    }
}
