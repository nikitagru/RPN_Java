package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws Exception {
	    String input = "322";

//	    Scanner in = new Scanner(System.in);
//	    String input = in.nextLine();

		RPN main = new RPN(input);
		if (main.isCorrect) {
			System.out.println(main.Compute());
		}


    }


}
