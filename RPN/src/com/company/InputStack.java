package com.company;

import java.util.Arrays;
import java.util.Stack;

public class InputStack implements RPNStack {
    private Stack<String> inputStack = new Stack<String>();

    public String[] operations = new String[]{"+", "-", "*", "/"};

    private int operationsCount = 0;
    private int operandsCount = 0;

    /**
     *
     * @param input Input string in RPN
     * @throws Exception Check null, empty string and count of operations
     */
    public InputStack(String input) throws Exception {
        if (CheckException(input)) {
            for (int i = 0; i < input.length(); i++) {
                inputStack.push(input.substring(i,i + 1));
            }
        }
    }

    public int Length() {
        return inputStack.size();
    }

    public String GetComponent(int i) {
        return inputStack.elementAt(i);
    }

    /**
     * Check exceptions of input string before computing RPN string
     * @param input Input string in RPN
     * @return Exist exceptions or not
     * @throws Exception Check null, empty string and count of operations
     */
    private boolean CheckException(String input) throws Exception {
        if (input != null && input != " ") {
            for (int i = 0; i < input.length(); i++) {
                if (IsOperation(input.substring(i, i + 1))) {
                    operationsCount++;
                } else {
                    operandsCount++;
                }
            }

            if (operandsCount > operationsCount + 1) {
                throw new Exception("Can not compute input expression: operation passed");
            }
            return true;
        } else {
            throw new Exception("Can not compute input expression: input string is null or space");
        }
    }

    /**
     * Check is operation input or not
     * @param input symbol which will be check
     * @return
     */
    public boolean IsOperation(String input) {
        if (Arrays.asList(operations).contains(input)) {
            return true;
        } else {
            return false;
        }
    }
}
