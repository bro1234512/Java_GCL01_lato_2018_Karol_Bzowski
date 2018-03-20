package com.example.calculator.logic;

import com.example.calculator.basic.Calculator;

import java.util.Scanner;

public class TriangleCalculator implements Calculator {
    @Override
    public double calculatePerimeter() {

        Scanner odczyt = new Scanner(System.in);

        System.out.println("Podaj boki trojakta: ");
        int a = odczyt.nextInt();
        int b = odczyt.nextInt();
        int c = odczyt.nextInt();
        if (a > 0 && b > 0 && c > 0) {
            return a + b + c;
        } else {
            return -1;
        }
    }
}
