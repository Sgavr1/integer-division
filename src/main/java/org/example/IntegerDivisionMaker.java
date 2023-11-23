package org.example;

public class IntegerDivisionMaker {
    public int division(Integer divisor, Integer dividend) {
        if (divisor == 0 || dividend == 0) {
            throw new ArithmeticException();
        }

        if(divisor<dividend){
            return 0;
        }

        Integer quotient = divisor/dividend;

        char[] quotientChars = quotient.toString().toCharArray();
        char[] divisorChars = divisor.toString().toCharArray();

        Integer product = Integer.parseInt(quotientChars[0]+"") * dividend;

        int lengthDivisor = divisor.toString().length();
        int lengthDividend = dividend.toString().length();
        int lengthQuotient = quotientChars.length;
        int lengthProduct = product.toString().length();

        String differenceString = "";
        int lastIndexFigure = 0;

        for (;lastIndexFigure<lengthDivisor; lastIndexFigure++) {
            differenceString += divisorChars[lastIndexFigure];

            if (Integer.parseInt(differenceString) > product){
                differenceString = Integer.toString(Integer.parseInt(differenceString) - product);
                lastIndexFigure++;
                break;
            }
        }

        int lengthLine = lengthDivisor + 2;
        lengthLine += lengthDividend < lengthQuotient ? lengthQuotient : lengthDividend;

        System.out.println("_"+divisor+"|"+dividend);
        System.out.println(" " + product + " ".repeat(lengthDivisor-lengthProduct) + "|" + "-".repeat(lengthLine-lengthDivisor-2));
        System.out.println(" " + "-".repeat(lengthProduct) + " ".repeat(lengthDivisor-lengthProduct) + "|" + String.valueOf(quotientChars));

        for (int i = 1; i<lengthQuotient; i++) {
            int padding = lastIndexFigure - differenceString.length();

            product = Integer.parseInt(quotientChars[i]+"") * dividend;

            for (;lastIndexFigure<lengthDivisor; lastIndexFigure++) {
                differenceString += divisorChars[lastIndexFigure];

                if (Integer.parseInt(differenceString) > product){
                    lastIndexFigure++;
                    break;
                }
            }

            System.out.println(" ".repeat(padding) + "_" + differenceString);

            differenceString = Integer.toString(Integer.parseInt(differenceString) - product);

            System.out.println(" ".repeat(padding+1) + product);
            System.out.println(" ".repeat(padding+1) + "-".repeat(product.toString().length()));

        }

        Integer remainder = divisor%dividend;

        System.out.println(" ".repeat(lengthDivisor-remainder.toString().length()+1) + remainder);

        return quotient;
    }
}