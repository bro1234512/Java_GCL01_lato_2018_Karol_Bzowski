package com.example.calculator.logic;

import com.example.calculator.basic.ExtendedCalculator;

import java.util.Scanner;

public class ExtendedCircleCalculator extends CircleCalculator implements ExtendedCalculator {

    @Override
    public void calculateArea() throws Exception {
        Scanner odczyt = new Scanner(System.in);

        System.out.println("Podaj promien r kołą: ");
        int a = odczyt.nextInt();

        if (a > 0) {
            System.out.println("Pole kołą wynosi: " + (a * a * 3.14));
        } else {
            throw new IllegalArgumentException("Podales złe wartości boków!");
        }

    }


}
