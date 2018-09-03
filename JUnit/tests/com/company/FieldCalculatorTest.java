package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.StyledEditorKit;

import static org.junit.jupiter.api.Assertions.*;

class FieldCalculatorTest {

    FieldCalculator fc;
    @BeforeEach
    void setUp() {
        fc = new FieldCalculator();
    }


    @AfterEach
    void tearDown() {
        System.out.println("Tests!");
    }

    @Test
    void calculateSquare() throws Exception {
        assertAll(
                () ->  assertTrue(!Double.isNaN(fc.calculateSquare(Math.PI))),
                () ->  assertNotEquals(Double.NaN , fc.calculateSquare(0)),
                () ->  assertNotEquals(Double.POSITIVE_INFINITY , fc.calculateSquare(-3))
        );
    }

    @Test
    void calculateCircle() throws Exception {
        assertAll(
                () ->  assertThrows(IllegalArgumentException.class, () -> { fc.calculateCircle(0); }),
                () ->  assertThrows(IllegalArgumentException.class, () -> { fc.calculateCircle(-4); }),
                () ->  assertTrue(!Double.isNaN(fc.calculateCircle(Math.PI))),
                () ->  assertNotEquals(Double.NaN , fc.calculateCircle(33)),
                () ->  assertNotEquals(Double.POSITIVE_INFINITY , fc.calculateCircle(4.3))
        );
    }

    @Test
    void calculateTriangle() throws Exception {
        assertAll(
                () ->  assertTrue(!Double.isNaN(fc.calculateTriangle(Math.PI))),
                () ->  assertNotEquals(Double.NaN , fc.calculateTriangle(0)),
                () ->  assertNotEquals(Double.POSITIVE_INFINITY , fc.calculateTriangle(-3))
        );
    }

    @Test
    void calculateRectangle() throws Exception {
        assertAll(
                () ->  assertTrue(!Double.isNaN(fc.calculateRectangle(Math.PI, 2))),
                () ->  assertNotEquals(Double.NaN , fc.calculateRectangle(0, -99)),
                () ->  assertNotEquals(Double.POSITIVE_INFINITY , fc.calculateRectangle(-3, 0.002))
        );
    }
}