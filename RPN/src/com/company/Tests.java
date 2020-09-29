package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    @Test
    void simple() throws Exception {
        RPN calculator = new RPN("238*+");
        assertEquals(26, calculator.Compute());
    }

    @Test
    void simpleMore() throws Exception {
        RPN calculator = new RPN("238*+4+5+");
        assertEquals(35, calculator.Compute());
    }

    @Test
    void additionOfMultiplies() throws Exception {
        RPN calculator = new RPN("45*89*+");
        assertEquals(92, calculator.Compute());
    }

    @Test
    void multiplieAndDivide() throws Exception {
        RPN calculator = new RPN("48*2/");
        assertEquals(16, calculator.Compute());
    }

    @Test
    void additionOfMultipliesDivide() throws Exception {
        RPN calculator = new RPN("48*56*+2/");
        assertEquals(31, calculator.Compute());
    }

    @Test
    void sumOfAdditionOfMultipliesDivides() throws Exception {
        RPN calculator = new RPN("48*56*+2/78*69*+2/+");
        assertEquals(86, calculator.Compute());
    }
}
