package VJudge;

import java.util.*;
import java.util.Stack;

public class TransformTheExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();        
	    scanner.nextLine(); 
        
        for (int i = 0; i < t; i++) {
            String expression = scanner.nextLine().trim();
            String rpn = infixToRPN(expression);
            System.out.println(rpn);
        }
        
        scanner.close();
    }
    
    private static String infixToRPN(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            if (Character.isLetter(ch)) {
                result.append(ch); 
            } else if (ch == '(') {
                stack.push(ch); 
            } else if (ch == ')') {
          
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Pop '(' from stack
            } else {
                
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        
        
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        return result.toString();
    }
    
    
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }
}

