package com.example.calculator.logic;

import com.example.calculator.basic.ExtendedCalculator;

import java.util.Scanner;

public class ExtendedTriangleCalculator extends TriangleCalculator implements ExtendedCalculator {
    @Override
    public void calculateArea() throws Exception {
        Scanner odczyt = new Scanner(System.in);

        System.out.println("Podaj podstawe trojakta: ");
        int a = odczyt.nextInt();
        System.out.println("Podaj wysokosc trojkata");
        int b = odczyt.nextInt();
        if (a > 0 && b > 0) {
            System.out.println("Pole trojakta wynosi: "+((a*b)/2));
        } else {
            throw new IllegalArgumentException("Podales złe wartości boków!");
        }

    }
}
