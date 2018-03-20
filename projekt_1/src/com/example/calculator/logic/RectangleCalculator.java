package com.example.calculator.logic;

import com.example.calculator.basic.Calculator;

import java.util.Scanner;

public class RectangleCalculator implements Calculator {
    @Override
    public double calculatePerimeter() {

        Scanner odczyt = new Scanner(System.in);
        System.out.println("Podaj boki prostąkąta: ");
        System.out.println("Podaj pierwszy bok: ");
        int a = odczyt.nextInt();
        System.out.println("Podaj drugi bok");
        int b = odczyt.nextInt();
        if (a > 0 && b > 0) {
            return (2 * a) + (2 * b);
        } else {
            return -1;
        }
    }
}
