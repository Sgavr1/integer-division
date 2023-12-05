package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IntegerDivisionMaker integerDivisionMaker = new IntegerDivisionMaker();
        IntegerDivisionPrinter printData = new IntegerDivisionPrinter();

        Scanner scanner = new Scanner(System.in);

        int divisor = scanner.nextInt();
        int dividend = scanner.nextInt();

        System.out.println(printData.print(integerDivisionMaker.make(divisor,dividend)));

    }
}