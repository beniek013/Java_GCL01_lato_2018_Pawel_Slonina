package com.company;

public class BasicCalculator  {
    public double calculateSum(double a, double b)
    {
        return  a + b;
    }
    public double caclulateDifference(double a, double b)
    {
        return  a - b;
    }
    public double calculateMultiplication(double a, double b)
    {
        return  a * b;
    }
    public double calculateDivision(double a, double b)
    {
        if(b==0)
            throw new IllegalArgumentException("Nie można dzieić przez 0!");
        return  a / b;
    }
    public double calculatePow(double a, double b)
    {
        return  Math.pow(a,b);
    }
    public double calculateSqrt(double a)
    {
        if(a < 0 )
            throw new IllegalArgumentException("Pierwiastek mniejszy od 0");
        return Math.sqrt(a);
    }
}
