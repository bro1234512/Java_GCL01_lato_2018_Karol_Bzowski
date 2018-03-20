package com.example.calculator.logic;

import com.example.calculator.basic.Calculator;

import java.util.Scanner;

public class CircleCalculator implements Calculator {

    @Override
    public double calculatePerimeter() {

        Scanner odczyt = new Scanner(System.in);
        System.out.println("Podaj promień r koła:  ");
        int a = odczyt.nextInt();

        if (a > 0) {
            return 2 * 3.14 * a;
        } else {
            return -1;
        }
    }
}