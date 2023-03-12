package com.calculator.calculatorfx;

import java.util.Objects;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorHandler {
    private String expression = "";
    private String display = "";


    public String handler(String symbol) {
        final String symbolRegex = "[+\\-*/^√]";
        final Pattern pattern = Pattern.compile(symbolRegex);
        final Matcher displayMatcher = pattern.matcher(display);
        final Matcher symbolMatcher = pattern.matcher(symbol);
        if (Objects.equals(symbol, "=")) {
            if (expression.length() > 2) {
                display = operate();
                expression = display;
            }
        } else if (symbolMatcher.find()) {
            if (!displayMatcher.find() && display.length() != 0) {
                display = symbol;
                expression += " " + symbol + " ";
            }
        } else if (symbol.matches("\\d")) {
            if (displayMatcher.find()) {
                display = "";
            }
            expression += symbol;
            display += symbol;
        } else if (symbol.matches("^(CE|C)$")) {
            if (Objects.equals(symbol, "CE")) {
                expression = "";
                display = "";
            } else {
                display = display.substring(0, display.length() - 1);
                expression = expression.substring(0, expression.length() - 1);
            }
        } else {
            if (display.matches("\\d")) {
                display += symbol;
                expression += symbol;
            }
        }
        return display;
    }

    public String operate() {
        String[] tokens = expression.split("\\s");
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for (String token : tokens) {
            if (token.matches("\\d+\\.?\\d*")) {
                numbers.push(Double.parseDouble(token));
            } else if (isOperator(token.charAt(0))) {
                while (!operators.empty()) {
                    numbers.push(cases(numbers.pop(), numbers.pop(), operators.pop()));
                }
                operators.push(token.charAt(0));
            }
        }
        while (!operators.empty()) {
            numbers.push(cases(numbers.pop(), numbers.pop(), operators.pop()));
        }
        return String.valueOf(numbers.pop());
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '√';
    }

   /* private boolean hasPrecedence(char op1, char op2) {
        if ((op1 == '^' || op1 == '√') && (op2 == '*' || op2 == '/')) {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }
    */

    private double cases(double a, double b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                if (a == 0) {
                    throw new ArithmeticException("Error");
                }
                return b / a;
            case '^':
                return Math.pow(b, a);
            case '√':
                return Math.pow(b, 1 / a);
            default:
                throw new IllegalArgumentException("Error");
        }
    }
}