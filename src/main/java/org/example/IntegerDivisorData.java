package org.example;

import java.util.ArrayList;
import java.util.List;

public class IntegerDivisorData {

    private List<StepDivisor> itemDivisions;
    private int divisor;
    private int dividend;
    private int remainder;
    private int quotient;


    public IntegerDivisorData() {
        itemDivisions = new ArrayList<>();
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }

    public void setDividend(int dividend) {
        this.dividend = dividend;
    }

    public void setRemainder(int remainder) {
        this.remainder = remainder;
    }

    public void setQuotient(int quotient) {
        this.quotient = quotient;
    }

    public List<StepDivisor> getItemDivisions() {
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