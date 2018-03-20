package com.example.calculator.logic;

import com.example.calculator.basic.Calculator;

import java.util.Scanner;

public class SquareCalculator implements Calculator {

    @Override
    public double calculatePerimeter() {

        Scanner odczyt = new Scanner(System.in);
        System.out.println("Podaj bok kwadratu: ");

        int a = odczyt.nextInt();
        if (a > 0) {
            return (4*a);
        } else {
            return -1;
        }


    }
}
