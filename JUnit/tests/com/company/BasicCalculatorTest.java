package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.function.Executable;

import javax.management.ConstructorParameters;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class BasicCalculatorTest {

    BasicCalculator bc;

    @BeforeEach
    void setUp() {
        bc = new BasicCalculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tests");
    }

    @Test
    public void calculateDivision() throws  Exception {
        assertAll(
                //() ->  assertThrows(IllegalArgumentException.class, () -> { bc.calculateDivision(-5,0); }),
                () ->  assertTrue(!Double.isNaN(bc.calculateMultiplication(-33,0.1121))),
                () ->  assertNotEquals(Double.POSITIVE_INFINITY , bc.calculateDivision(-99, 2)),
                () ->  assertNotEquals(Double.POSITIVE_INFINITY , bc.calculateDivision(222, -9))
        );
    }
    @Test
    public void calculateMultiplication() throws Exception {
        assertAll(

                () ->  assertTrue(!Double.isNaN(bc.calculateMultiplication(0.33,0))),
                () ->  assertNotEquals(Double.NaN , bc.calculateMultiplication(0, 4.333)),
                () ->  assertNotEquals(Double.POSITIVE_INFINITY , bc.calculateMultiplication(-99, 2))
        );
    }

    @Test
    public void calculateSum() throws Exception {
        assertAll(
                () ->  assertTrue(!Double.isNaN(bc.calculateSum(Math.PI,0))),
                () ->  assertNotEquals(Double.NaN , bc.calculateSum(44, 99.2222)),
                () ->  assertNotEquals(Double.POSITIVE_INFINITY , bc.calculateSum(-99, 2))
        );
    }

    @Test
    public void caclulateDifference() throws Exception {
        assertAll(
                () ->  assertTrue(!Double.isNaN(bc.caclulateDifference(Math.PI,0))),
                () ->  assertNotEquals(Double.NaN , bc.caclulateDifference(44, 99.2222)),
                () ->  assertNotEquals(Double.POSITIVE_INFINITY , bc.caclulateDifference(-99, 2))
        );
    }

    @Test
    public void calculatePow() throws Exception {
        assertAll(
                () ->  assertTrue(!Double.isNaN(bc.calculatePow(7,-2))),
                () ->  assertNotEquals(Double.NaN , bc.calculatePow(2, 0.221)),
                () ->  assertNotEquals(Double.POSITIVE_INFINITY , bc.calculatePow(-9, 27))
        );
    }

    @Test
    public void calculateSqrt() throws Exception {
        assertAll(
                //() ->  assertThrows(IllegalArgumentException.class, () -> { bc.calculateSqrt(-7); }),
                () ->  assertTrue(!Double.isNaN(bc.calculateSqrt(Math.PI))),
                () ->  assertNotEquals(Double.NaN , bc.calculateSqrt(44)),
                () ->  assertNotEquals(Double.POSITIVE_INFINITY , bc.calculateSqrt(0))
        );
    }


}