package com.company;

public class FieldCalculator {
    public double calculateSquare(double a)
    {
        return a*a;
    }
    public double calculateCircle(double r)
    {
        if(r <= 0)
            throw new IllegalArgumentException("Promien mniejszy/rowny 0");
        return Math.PI * r * r;
    }
    public double calculateTriangle(double a)
    {
        return Math.pow(a,2) * Math.sqrt(3) / 4;
    }
    public double calculateRectangle(double a, double b)
    {
        return a*b;
    }
}
