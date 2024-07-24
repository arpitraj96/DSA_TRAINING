package VJudge;
import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    private Node front; 
    private Node rear; 

    public Queue() {
        front = null;
        rear = null;
    }

    public void enqueue(int x) {
        Node newNode = new Node(x);
        
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }
    public String dequeue() {
        if (isEmpty()) {
            return "Empty";
        }
        
        int removedValue = front.data;
        front = front.next;
        
        if (front == null) {
            rear = null;
        }
        
        return Integer.toString(removedValue);
    }
  
    public boolean isEmpty() {
        return front == null;
    }
}

public class ImplementQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); 
        scanner.nextLine();
        Queue queue = new Queue();

        for (int i = 0; i < T; i++) {
            String operation = scanner.nextLine();
            String[] parts = operation.split(" ");
            String command = parts[0];

            if (command.equals("Enqueue")) {
                int x = Integer.parseInt(parts[1]);
                queue.enqueue(x);
            } else if (command.equals("Dequeue")) {
                String result = queue.dequeue();
                System.out.println(result);
            }
        }
        scanner.close();
    }
}
