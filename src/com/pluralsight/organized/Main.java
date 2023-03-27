package com.pluralsight.organized;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCode = {'d', 'a', 's', 'm'};
        double[] result = new double[opCode.length];

        if (args.length == 0) {
            for (int i = 0; i < opCode.length; i++) {
                System.out.println(execute(opCode[i], leftVals[i], rightVals[i]));

            }

        } else if (args.length == 1 && args[0].equals("interactive")) {
            executeInteractively();

        }
        else if(args.length == 3){
            handleCommandLineArgs(args);

        }  else {
            System.out.println("Please provide an operation code and 2 numeric values");
        }



    }

    private static void handleCommandLineArgs(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);

        double result = execute(opCode, leftVal, rightVal);
        System.out.println(result);

    }

    static void executeInteractively() {
        System.out.println("Enter and operation and two numbers:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);



    }

    private static void performOperation(String[] parts) {
        char opcode = opCodeFromString(parts[0]);
        double leftVal = valueFromWord(parts[1]);
        double rightVal = valueFromWord(parts[2]);
        System.out.println("" + opcode + " " + leftVal + " " + rightVal);
        double calculate = execute(opcode, leftVal, rightVal);
        displayResult(symbolFromOpCode(opcode), leftVal, rightVal, calculate);
    }

    private static void displayResult(char opcode, double leftVal, double rightVal, double calc) {
        StringBuilder result = new StringBuilder();
        result.append(leftVal + " " + opcode + " " + rightVal + " " + "= " + calc);
        System.out.println(result.toString());
    }

    static double execute(char opCode, double leftVal, double rightVal) {
        double result;
       switch (opCode) {
           case 'a':
               result = leftVal + rightVal;
               break;
           case 's':
               result = leftVal - rightVal;
               break;
           case 'm':
               result = leftVal * rightVal;
               break;
           case 'd':
               result = rightVal != 0 ? leftVal / rightVal : 0.0d;
               break;
           default:
               System.out.println("Invalid opCode: " + opCode);
               result = 0.0d;
               break;

       }
       return result;

    }

    static char opCodeFromString(String operationName) {
        return operationName.charAt(0);
    }

    static Double valueFromWord(String word){

        String[] numberWords = {"zero", "one", "two", "three", "four",
                                "five", "six", "seven", "eight", "nine"};
        double value = 0d;
        for (int index = 0; index < numberWords.length; index++){
            if (word.equals(numberWords[index])){
                value = index;
                break;
            }

        }

        return value;
        /*Map<String, Double> numberWords = new HashMap<String, Double>(10);
        numberWords.put("zero", 0.0);
        numberWords.put("one", 1.0);
        numberWords.put("two", 2.0);
        numberWords.put("three", 3.0);
        numberWords.put("four", 4.0);
        numberWords.put("five", 5.0);
        numberWords.put("six", 6.0);
        numberWords.put("seven", 7.0);
        numberWords.put("eight", 8.0);
        numberWords.put("nine", 9.0);

       Double wordVal = numberWords.get("nine");
       Object wordval = numberWords.get("nine");
        System.out.println(wordval);
        return wordVal;*/




    }

    private static char symbolFromOpCode(char opCode){
        char[] opCodes = {'a', 's', 'm', 'd'};
        char[] symbols = {'+', '-', '*', '/'};
        char symbol = ' ';
        for(int i = 0; i < opCodes.length; i++){
            if (opCode == opCodes[i]){
                symbol = symbols[i];
                break;
            }
        }
        return symbol;
    }

    static void stringBuilder() {
        String location = "Florida";
        int flightNumber = 175;
        StringBuilder sb = new StringBuilder(40);
        sb.append(location);
        sb.append(flightNumber);
        String message = sb.toString();
        int position = sb.indexOf(location + " ");
        sb.insert(position, " man ");


    }






}