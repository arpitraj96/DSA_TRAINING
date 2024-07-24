package VJudge;

import java.util.Scanner;
import java.util.Stack;

public class RectangularAreaUnderHistogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); 
        scanner.nextLine(); 
        
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); 
            scanner.nextLine(); 
            int[] heights = new int[N];
            
            
            for (int i = 0; i < N; i++) {
                heights[i] = scanner.nextInt();
            }
            scanner.nextLine(); 
            
            
            long maxArea = getMaxRectangleArea(heights);
            
            
            System.out.println(maxArea);
        }
        
        scanner.close();
    }
    
        private static long getMaxRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        long maxArea = 0;
        
        int i = 0;
        while (i < n) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                long area = (long) heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        
        while (!stack.isEmpty()) {
            int top = stack.pop();
            long area = (long) heights[top] * (stack.isEmpty() ? n : n - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
}
