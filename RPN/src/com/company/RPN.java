package com.company;


import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Stack;

public class RPN implements RPNMain {

    Stack<String> inputStack = new Stack<String>();

    private String[] operations = new String[]{"+", "-", "*", "/"};

    public boolean isCorrect;

    public RPN(String input) {
        isCorrect = CheckException(input);
        for (int i = 0; i < input.length(); i++) {
            inputStack.push(input.substring(i,i + 1));
        }
    }

    public int Compute() {

        Stack<Integer> resultStack = new Stack<Integer>();
        for (int i = 0; i < inputStack.size(); i++) {
            String currentComponent = inputStack.get(i);

            if (!IsOperation(currentComponent)) {
                resultStack.push(Integer.parseInt(currentComponent));
            } else {
                if (resultStack.size() >= 2) {
                    int last = resultStack.pop();
                    int prev = resultStack.pop();
                    int result = 0;

                    switch (currentComponent) {
                        case "+":
                            result = prev + last;
                            break;
                        case "-":
                            result = prev - last;
                            break;
                        case "*":
                            result = prev * last;
                            break;
                        case "/":
                            if(last != 0) {
                                result = prev / last;
                            } else {
                                System.out.println("Ошибка: деление на ноль");
                                break;
                            }
                            break;
                        default:
                            System.out.println("Некорректная операция");
                            break;
                    }
                    resultStack.push(result);
                } else {
                    resultStack.push(Integer.parseInt(currentComponent));
                }
            }
        }
        return resultStack.elementAt(0);
    }

    public boolean IsOperation(String input) {
        if (Arrays.asList(operations).contains(input)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean CheckException(String input) {
        int operationsCount = 0;
        int operandsCount = 0;
        if (input != null && input != " ") {
            for (int i = 0; i < input.length(); i++) {
                if (IsOperation(input.substring(i, i + 1))) {
                    operationsCount++;
                } else {
                    operandsCount++;
                }
            }

            if (operandsCount != operationsCount + 1)  {
                System.out.println("Ошибка: неправильное соотношение количества операций и операндов");
                return false;
            }
            return true;
        } else {
            System.out.println("Ошибка: строка null или пустая");
            return false;
        }
    }

}
