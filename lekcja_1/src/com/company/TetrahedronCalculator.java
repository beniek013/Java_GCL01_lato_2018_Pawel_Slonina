package com.company;

import java.util.Scanner;

public class TetrahedronCalculator {
    Scanner in = new Scanner(System.in);
    double calculateBaseArea(){
        double r = in.nextDouble();
        double h = in.nextDouble();
        return r*r*Math.PI *h/3;
    }
    double calculateBasePerimeter() {
        double r = in.nextDouble();
        return r*r*Math.PI;
    }
}