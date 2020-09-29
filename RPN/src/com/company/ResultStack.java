package com.company;

import java.util.Stack;

public class ResultStack implements RPNStack {
    private Stack<String> resultStack = new Stack<String>();


    @Override
    public int Length() {
        return resultStack.size();
    }

    @Override
    public String GetComponent(int i) {
        return resultStack.elementAt(i);
    }

    /**
     * Adds result in result stack
     * @param result result of the expression
     */
    public void Add(int result) {
        resultStack.push(result + "");
    }

    /**
     * Deletes element from result stack
     * @return deleted element
     */
    public String Delete() {
        return resultStack.pop();
    }

    /**
     * Convert first element in result stack to integer
     * @return integer result
     */
    public int StackToInt() {
        return Integer.parseInt(resultStack.elementAt(0));
    }
}
