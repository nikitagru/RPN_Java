package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    @Test
    void simple() throws Exception {
        RPNImpl calculator = new RPNImpl("238*+");
        assertEquals(26, calculator.compute());
    }

    @Test
    void simpleMore() {
        RPNImpl calculator = new RPNImpl("238*+4+5+");
        assertEquals(35, calculator.compute());
    }

    @Test
    void additionOfMultiplies() {
        RPNImpl calculator = new RPNImpl("45*89*+");
        assertEquals(92, calculator.compute());
    }

    @Test
    void multiplieAndDivide() throws Exception {
        RPNImpl calculator = new RPNImpl("48*2/");
        assertEquals(16, calculator.compute());
    }

    @Test
    void additionOfMultipliesDivide() throws Exception {
        RPNImpl calculator = new RPNImpl("48*56*+2/");
        assertEquals(31, calculator.compute());
    }

    @Test
    void sumOfAdditionOfMultipliesDivides() throws Exception {
        RPNImpl calculator = new RPNImpl("48*56*+2/78*69*+2/+");
        assertEquals(86, calculator.compute());
    }
    @Test
    void sumOfAdditionOfMultipliesDivides1() throws Exception {
        RPNImpl calculator = new RPNImpl("325");
        assertEquals(86, calculator.compute());
    }
}
