package com.company;

public interface RPNStack {
    /**
     *
     * @return Count of elements
     */
    int Length();

    /**
     *
     * @param i current position of the element
     * @return Element on index i in the stack
     */
    String GetComponent(int i);

}

