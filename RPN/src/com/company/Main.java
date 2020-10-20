package com.company;

public class Main {


    public static void main(String[] args) {
	    String input = "34+2*";

//	    Scanner in = new Scanner(System.in);
//	    String input = in.nextLine();

		RPNImpl main = new RPNImpl(input);

			System.out.println(main.compute());

    }


}
