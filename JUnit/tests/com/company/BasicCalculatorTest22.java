package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BasicCalculatorTest22 {

    BasicCalculator bc;
    @BeforeEach
    void setUp() {
        bc = new BasicCalculator();
    }

    @ParameterizedTest
    @ValueSource(doubles = {4,5,-11})
    public void testDivision(Double liczby) {
        assertThrows(IllegalArgumentException.class, () -> {bc.calculateDivision(liczby,0);});
    }

    @ParameterizedTest
    @ValueSource(doubles = {-3,-0.0001})
    public void testSqrt(Double liczby) {
        assertThrows(IllegalArgumentException.class, () -> {bc.calculateSqrt(liczby);});
    }
}