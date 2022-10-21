package Dasari_Yin_ProjectTwoPostfixInfix.src;

import javax.swing.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string in infix: ");
        String infixString = getInput(scanner);
        System.out.println("Infix: " + infixString);

         */
        while (true) {
            String infixString = "";
            infixString = JOptionPane.showInputDialog(null, "Infix Input");
            //System.out.println("Infix: " + infixString);
            String postfixString = infixToPostfix(infixString);
            JOptionPane.showMessageDialog(null, ("Postfix Result: " + postfixString));
            //System.out.println("Postfix: " + postfixString);
            //System.out.println(calculate(postfixString));
        }
    }

    public static String getInput(Scanner scanner) {
        return scanner.nextLine();
    }

    public static int pemdasPriority(String s) {
        switch (s.charAt(0)) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixToPostfix(String infixString) {
        if (infixString.toLowerCase().contains("quit")) {
            System.exit(0);
        }
        String postfixString = "";
        Stack<String> stack = new Stack<String>(); // Top of the stack is highest priority operator
        String[] infixArray = infixString.trim().split(" ");
        System.out.println(Arrays.toString(infixArray));

        for (int i = 0; i < infixArray.length; i++) {
            String s = infixArray[i];
            if (isInteger(s)) {
                postfixString += s;
                postfixString += " ";
            }
            else if (s.equals("(")) {
                stack.push(s);
            }
            else if (s.equals(")")) {
                while (!stack.peek().equals("(")) {
                    System.out.println("Stack: " + stack);
                    postfixString += stack.pop();
                    postfixString += " ";
                }
                stack.pop(); // remove the open parenthesis
            }
            else {
                while (!stack.isEmpty() && pemdasPriority(s) <= pemdasPriority(stack.peek())) {
                    postfixString += stack.pop();
                    postfixString += " ";
                }
                stack.push(s);
            }
            System.out.println("s: " + s);
            System.out.println("Postfix String: " + postfixString);
            System.out.println(stack);
            System.out.println();
        }
        // Pop the remaining operators
        while (!stack.isEmpty()) {
            postfixString += stack.pop();
            postfixString += " ";
        }
        System.out.println(stack);

        return postfixString;
    }

    public static boolean isInteger(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static double calculate(String postfixString) {
        String[] postfixArray = postfixString.trim().split(" ");
        System.out.println(Arrays.toString(postfixArray));
        Stack<Double> stack = new Stack<Double>();
        for (int i = 0; i < postfixArray.length; i++) {
            String s = postfixArray[i];
            if (isInteger(s)) {
                stack.push(Double.parseDouble(s));
                System.out.println(stack);
            }
            else {
                double a = stack.pop();
                double b = stack.pop();
                switch (s.charAt(0)) {
                    case '+': stack.push(b + a);
                        break;
                    case '-': stack.push(b - a);
                        break;
                    case '*': stack.push(b * a);
                        break;
                    case '/': stack.push(b / a);
                        break;
                    case '^': stack.push(Math.pow(b, a));
                        break;
                }
            }
        }
        return stack.pop();
    }
}