package VJudge;

// import java.util.Scanner;

// public class CollectingMangoes {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int t = sc.nextInt();
//         sc.nextLine();

//         while (t>0) {
//             int n = sc.nextInt();
//             Stack stack = new Stack(n);
//             System.out.println("Case 1: ");
//             while (n>0) {
//                 String operation = sc.nextLine().trim();
//                 if (operation.startsWith("A")) {
//                     int x = Integer.parseInt(operation.substring(5).trim());
//                     stack.push(x);
//                 } else if (operation.equals("R")) {
//                     int popped = stack.pop();
//                     if (popped == Integer.MIN_VALUE) {
//                         System.out.println("Empty");
//                     } else {
//                         System.out.println(popped);
//                     }
//                 } else if(operation.equals("Q")){

//                 }
//                 n--;
//             }
//             t--;
//         }
//         sc.close();
//     }
// }
// class Stack {
//     private int[] arr;
//     private int top;
//     private int capacity;

//     public Stack(int size) {
//         arr = new int[size];
//         capacity = size;
//         top = -1;
//     }

//     public void push(int x) {
//         if (top == capacity - 1) {
//             return;
//         }
//         arr[++top] = x;
//     }

//     public int pop() {
//         if (isEmpty()) {
//             return Integer.MIN_VALUE;
//         }
//         return arr[top--];
//     }

//     public int peek() {
//         if (isEmpty()) {
//             return Integer.MIN_VALUE;
//         }
//         return arr[top];
//     }

//     public boolean isEmpty() {
//         return top == -1;
//     }

//     public boolean isFull() {
//         return top == capacity - 1;
//     }
// }


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CollectingMangoes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder output = new StringBuilder();
        
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = Integer.parseInt(br.readLine().trim());
            Stack<Integer> stack = new Stack<>();
            Stack<Integer> maxStack = new Stack<>();
            output.append("Case ").append(caseNum).append(":\n");
            
            while (n > 0) {
                String operation = br.readLine().trim();
                
                if (operation.startsWith("A")) {
                    int x = Integer.parseInt(operation.substring(2).trim());
                    stack.push(x);
                    if (maxStack.isEmpty() || x >= maxStack.peek()) {
                        maxStack.push(x);
                    }
                } else if (operation.equals("R")) {
                    if (!stack.isEmpty()) {
                        int removed = stack.pop();
                        if (removed == maxStack.peek()) {
                            maxStack.pop();
                        }
                    }
                } else if (operation.equals("Q")) {
                    if (stack.isEmpty()) {
                        output.append("Empty\n");
                    } else {
                        output.append(maxStack.peek()).append("\n");
                    }
                }
                
                n--;
            }
        }
        
        System.out.print(output);
        br.close();
    }
}
