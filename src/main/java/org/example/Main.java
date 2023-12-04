package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IntegerDivisionMaker integerDivisionMaker = new IntegerDivisionMaker();
        DataIntegerDivisionPrinter printData = new DataIntegerDivisionPrinter();

        Scanner scanner = new Scanner(System.in);

        int divisor = scanner.nextInt();
        int dividend = scanner.nextInt();

        printData.print(integerDivisionMaker.division(divisor,dividend));

    }
}