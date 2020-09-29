package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws Exception {
	    String input = "238*+97/+";

//	    Scanner in = new Scanner(System.in);
//	    String input = in.nextLine();
	    InputStack stack = new InputStack(input);
	    ResultStack resultStack = new ResultStack();



	    for (int i = 0; i < stack.Length(); i++) {
	    	String currentComponent = stack.GetComponent(i);

	    	if (!stack.IsOperation(currentComponent)) {
	        	resultStack.Add(Integer.parseInt(currentComponent));
			} else {
				if (resultStack.Length() >= 2) {
					int last = Integer.parseInt(resultStack.Delete());
					int prev = Integer.parseInt(resultStack.Delete());
					int result = 0;

					if (currentComponent.equals("+")) {
						result = prev + last;
					} else if (currentComponent.equals("-")) {
						result = prev - last;
					} else if (currentComponent.equals("*")) {
						result = prev * last;
					} else if (currentComponent.equals("/")) {
						result = prev / last;
					} else {
						throw new Exception("Invalid operation");
					}

					resultStack.Add(result);
				} else {
					resultStack.Add(Integer.parseInt(currentComponent));
				}
			}
        }

		System.out.println(resultStack.StackToInt());
    }
}
