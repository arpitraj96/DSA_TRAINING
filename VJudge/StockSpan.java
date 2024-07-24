package VJudge;
import java.util.*;
public class StockSpan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); 
        
        while (T-- > 0) {
            int N = scanner.nextInt(); 
            int[] prices = new int[N];
            for (int i = 0; i < N; i++) {
                prices[i] = scanner.nextInt();
            }
            int[] spans = calculateStockSpan(prices);
            for (int span : spans) {
                System.out.print(span + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
    
    private static int[] calculateStockSpan(int[] prices) {
        int n = prices.length;
        int[] spans = new int[n];
        Stack<Integer> indexStack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!indexStack.isEmpty() && prices[indexStack.peek()] <= prices[i]) {
                indexStack.pop();
            }
          
            if (indexStack.isEmpty()) {
                spans[i] = i + 1;
            } else {
                spans[i] = i - indexStack.peek();
            }
            indexStack.push(i);
        }
        
        return spans;
    }
}
