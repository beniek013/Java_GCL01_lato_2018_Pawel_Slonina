package com.company;

import java.util.Scanner;

public class ConeCalculator {
    Scanner in = new Scanner(System.in);
    double calculateBaseArea(){
        double a = in.nextDouble();
        return a*a*Math.sqrt(3);
    }
    double calculateBasePerimeter() {
        double a = in.nextDouble();
        return 6 * a;
    }
}
