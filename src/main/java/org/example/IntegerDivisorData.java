package org.example;

import java.util.ArrayList;

public class IntegerDivisorData {

    private ArrayList<ItemDivisor> itemDivisions;
    private int divisor;
    private int dividend;
    private int remainder;
    private int quotient;


    public IntegerDivisorData() {
        itemDivisions = new ArrayList<>();
    }

    public void setDivisor(int divisor) {
        if (divisor != 0) {
            this.divisor = divisor;
        }
    }

    public void setDividend(int dividend) {
        if (dividend != 0) {
            this.dividend = dividend;
        }
    }

    public void setRemainder(int remainder) {
        if (remainder > -1) {
            this.remainder = remainder;
        }
    }

    public void setQuotient(int quotient) {
        this.quotient = quotient;
    }

    public ArrayList<ItemDivisor> getItemDivisions() {
        return itemDivisions;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getDividend() {
        return dividend;
    }

    public int getRemainder() {
        return remainder;
    }

    @Override
    public boolean equals(Object obj) {
        IntegerDivisorData data = (IntegerDivisorData) obj;

        if (this.divisor == data.getDivisor() && this.dividend == data.getDividend() && this.remainder == data.getRemainder() && this.quotient == data.getQuotient()) {
            if (this.itemDivisions.size() == data.getItemDivisions().size()) {
                for (int i = 0; i < this.itemDivisions.size(); i++) {
                    if ( !this.itemDivisions.get(i).equals(data.getItemDivisions().get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }

        return false;
    }

    public int getQuotient() {
        return quotient;
    }
}
