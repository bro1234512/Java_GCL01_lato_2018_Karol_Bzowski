package com.example.calculator.ui;

import com.example.calculator.basic.*;
import com.example.calculator.logic.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Witaj w kalkulatorze!\n Wybierz figure: \n 1 - Kwadrat\n 2 - Prostokąt\n 3 - Koło\n 4 - Trójkąt");
        try {
            Scanner buff = new Scanner(System.in);
            int wybor = buff.nextInt();
            Calculator calc;
            ExtendedCalculator extCalc;
            switch (wybor) {
                case 1:
                    System.out.println("Oblicz:\n 1 - Obwód\n 2 - Pole");
                    wybor = buff.nextInt();

                    switch (wybor) {
                        case 1:
                            calc = new SquareCalculator();
                            System.out.println("Obwód kwadratu wynosi: " + calc.calculatePerimeter());
                            break;
                        case 2:
                            extCalc = new ExtendedSquareCalculator();
                            extCalc.calculateArea();
                            break;

                    }
                    break;
                case 2:
                    System.out.println("Oblicz:\n 1 - Obwód\n 2 - Pole");
                    wybor = buff.nextInt();

                    switch (wybor) {
                        case 1:
                            calc = new RectangleCalculator();
                            System.out.println("Obwód kwadratu wynosi: " + calc.calculatePerimeter());
                            break;
                        case 2:
                            extCalc = new ExtendedRectangleCalculator();
                            extCalc.calculateArea();
                            break;

                    }
                    break;
                case 3:
                    System.out.println("Oblicz:\n 1 - Obwód\n 2 - Pole");
                    wybor = buff.nextInt();

                    switch (wybor) {
                        case 1:
                            calc = new CircleCalculator();
                            System.out.println("Obwód kwadratu wynosi: " + calc.calculatePerimeter());
                            break;
                        case 2:
                            extCalc = new ExtendedCircleCalculator();
                            extCalc.calculateArea();
                            break;

                    }
                    break;
                case 4:
                    System.out.println("Oblicz:\n 1 - Obwód\n 2 - Pole");
                    wybor = buff.nextInt();

                    switch (wybor) {
                        case 1:
                            calc = new TriangleCalculator();
                            System.out.println("Obwód kwadratu wynosi: " + calc.calculatePerimeter());
                            break;
                        case 2:
                            extCalc = new ExtendedTriangleCalculator();
                            extCalc.calculateArea();
                            break;

                    }
                    break;


                default:
                    System.out.println("Podales zly argument!");
            }


        } catch (ArithmeticException e) {
            System.out.println("Blad!");
        }
    }
}
