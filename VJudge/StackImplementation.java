package VJudge;
// import java.util.Scanner;
// public class ImplementStack {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int t = sc.nextInt();
//         sc.nextLine();
//         Stack stack = new Stack(t);
        
//         while (t > 0) {
//             String operation = sc.nextLine();
            
//             if (operation.contains(" ")) {
//                 String[] separate = operation.split(" ");
//                 if (separate[0].equals("push")) { 
//                     stack.push(Integer.parseInt(separate[1]));
//                 }
//             } else if (operation.equals("pop")) { 
//                 int ele = stack.pop();
//                 if (ele != -1) {
//                     System.out.println(ele);
//                 }
//             }
//             t--;
//         }
//         sc.close();
//     }
// }

// class Stack {
//     private int arr[];
//     private int top;
//     private int capacity;

//     Stack(int size) {
//         arr = new int[size];
//         capacity = size;
//         top = -1;
//     }

//     public void push(int x) {
//         if (isFull()) {
//             // System.out.println("Stack Overflow");
//             return;
//         }
//         // System.out.println("Inserting " + x);
//         arr[++top] = x;
//     }

//     public int pop() {
//         if (isEmpty()) {
//             System.out.println("Empty");
//             return -1; 
//         }
//         return arr[top--];
//     }

//     public boolean isEmpty() {
//         return top == -1;
//     }

//     public boolean isFull() {
//         return top == capacity - 1;
//     }
// }


import java.util.Scanner;

public class StackImplementation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        
        Stack stack = new Stack(T);
        
        for (int i = 0; i < T; i++) {
            String operation = sc.nextLine().trim();
            
            if (operation.startsWith("push")) {
                int x = Integer.parseInt(operation.substring(5).trim());
                stack.push(x);
            } else if (operation.equals("pop")) {
                int popped = stack.pop();
                if (popped == Integer.MIN_VALUE) {
                    System.out.println("Empty");
                } else {
                    System.out.println(popped);
                }
            }
        }
        
        sc.close();
    }

}

class Stack {
    private int[] arr;
    private int top;
    private int capacity;

    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (top == capacity - 1) {
            return;
        }
        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}
