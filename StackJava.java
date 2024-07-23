import java.util.Scanner;

public class StackJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Stack: ");
        int size = sc.nextInt();
        Stack stack = new Stack(size);
        while (true) {
            System.out.println("\nSelect, What you want\n1. Push\n2. Pop\n3. Display\n4. isEmpty\n5. isFull\n6. Peek\n0. Exit\n");
            int choice = sc.nextInt();
            if(choice == 1) {
                System.out.print("Enter a number into the Stack: ");
                int num = sc.nextInt();
                stack.push(num);
            } else if(choice == 3) {
                stack.display();
            } else if(choice == 4) {
                System.out.println(stack.isEmpty());
            } else if(choice == 2) {
                int popped = stack.pop();
                System.out.println("Popped element: " + popped);
            } else if(choice == 5) {
                System.out.println(stack.isFull());
            } else if(choice == 6) {
                System.out.print("Enter Position: ");
                int pos = sc.nextInt();
                int peeked = stack.peek(pos);
                System.out.println("Peeked element: " + peeked);
            } else if(choice == 0) {
              stack.display();
                System.out.println("Terminating.........");
                break;
            } else {
                System.out.println("Enter a valid Choice.");
            }
        }
        sc.close();
    }
}

class Stack {
    private int arr[];
    private int top;
    private int capacity;

    Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        System.out.println("Inserting " + x);
        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            return -1;
        }
        return arr[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int peek(int pos) {
        if (pos <= 0 || pos > top + 1) {
            System.out.println("Invalid position");
            return -1;
        }
        return arr[top - pos + 1];
    }
}
