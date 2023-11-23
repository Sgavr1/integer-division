package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IntegerDivisionMaker integerDivisionMaker = new IntegerDivisionMaker();

        Scanner scanner = new Scanner(System.in);

        int division = scanner.nextInt();
        int dividend = scanner.nextInt();

        integerDivisionMaker.division(division,dividend);
    }
}