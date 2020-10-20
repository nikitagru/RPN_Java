package com.company;


import java.util.Arrays;
import java.util.Stack;

public class RPNImpl implements RPN {

    Stack<String> inputStack = new Stack<String>();

    private String[] operations = new String[]{"+", "-", "*", "/"};

    private boolean isCorrect;

    public RPNImpl(String input) {
        isCorrect = checkException(input);
        for (int i = 0; i < input.length(); i++) {
            inputStack.push(input.substring(i,i + 1));

        }
    }

    public int compute() {
        int resultOut = 0;
        if (isCorrect) {
            Stack<Integer> resultStack = new Stack<Integer>();
            for (int i = 0; i < inputStack.size(); i++) {
                String currentComponent = inputStack.get(i);

                if (!isOperation(currentComponent)) {
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
            resultOut = resultStack.elementAt(0);
        }
        return resultOut;
    }

    private boolean isOperation(String input) {
        return (Arrays.asList(operations).contains(input));
    }

    private boolean checkException(String input) {
        int operationsCount = 0;
        int operandsCount = 0;
        if (input != null && input != " ") {
            for (int i = 0; i < input.length(); i++) {
                if (isOperation(input.substring(i, i + 1))) {
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
