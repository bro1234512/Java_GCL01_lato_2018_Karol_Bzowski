package com.example.calculator.logic;

import com.example.calculator.basic.ExtendedCalculator;

import java.util.Scanner;

public class ExtendedRectangleCalculator extends RectangleCalculator implements ExtendedCalculator {
    @Override
    public void calculateArea() throws Exception {
        Scanner odczyt = new Scanner(System.in);

        System.out.println("Podaj bok prostokąta: ");
        int a = odczyt.nextInt();
        System.out.println("Podaj drugi bok prostąkąta:");
        int b = odczyt.nextInt();
        if (a > 0 && b > 0) {
            System.out.println("Pole prostąkąta wynosi: "+(a*b));
        } else {
            throw new IllegalArgumentException("Podales złe wartości boków!");
        }

    }
}
