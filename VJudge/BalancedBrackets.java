package VJudge;

import java.util.*;
import java.util.Stack;

public class BalancedBrackets {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); 
        
        for (int i = 0; i < t; i++) {
            String s = scanner.nextLine();
            String result = isBalanced(s);
            System.out.println(result);
        }
        
        scanner.close();
    }
    
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                
                char top = stack.pop();
                if ((ch == '}' && top != '{') ||
                    (ch == ']' && top != '[') ||
                    (ch == ')' && top != '(')) {
                    return "NO";
                }
            }
        }
        
        if (!stack.isEmpty()) {
            return "NO";
        }
        
        return "YES";
    }
}

