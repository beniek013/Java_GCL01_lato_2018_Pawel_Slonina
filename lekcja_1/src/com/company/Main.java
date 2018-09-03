package com.company;
public class Main {
    public static void main(String[] args) {
        ConeCalculator a = new ConeCalculator();
        System.out.println(Math.round(a.calculateBaseArea()));
        TetrahedronCalculator b = new TetrahedronCalculator();
        System.out.println(Math.round(b.calculateBaseArea()));
    }
}