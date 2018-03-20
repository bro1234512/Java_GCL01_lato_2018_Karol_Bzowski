package com.example.calculator.logic;

import com.example.calculator.basic.ExtendedCalculator;

import java.util.Scanner;

public class ExtendedSquareCalculator  extends SquareCalculator implements ExtendedCalculator {
    @Override
    public void calculateArea() throws Exception {
        Scanner odczyt = new Scanner(System.in);

        System.out.println("Podaj bok kwadratu: ");
        int a = odczyt.nextInt();

        if (a > 0 ) {
            System.out.println("Pole kwadratu wynosi: "+(a*a));
        } else {
            throw new IllegalArgumentException("Podales złe wartości boków!");
        }

    }
}
