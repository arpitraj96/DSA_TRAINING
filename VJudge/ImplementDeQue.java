package VJudge;
import java.util.Scanner;
class Deque {
    private int[] elements;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Deque(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity];
        front = -1;
        rear = 0;
        size = 0;
    }

        public void push_front(int x) {
        if (isFull()) {
            // System.out.println("Deque is full. Cannot push_front " + x);
            return;
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }

        elements[front] = x;
        size++;
    }

       public void push_back(int x) {
        if (isFull()) {
            // System.out.println("Deque is full. Cannot push_back " + x);
            return;
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }

        elements[rear] = x;
        size++;
    }

        public String pop_front() {
        if (isEmpty()) {
            return "Empty";
        }

        int removedValue = elements[front];
        if (front == rear) {
            front = -1;
            rear = 0;
        } else {
            front = (front + 1) % capacity;
        }

        size--;
        return Integer.toString(removedValue);
    }

       public String pop_back() {
        if (isEmpty()) {
            return "Empty";
        }

        int removedValue = elements[rear];
        if (front == rear) {
            front = -1;
            rear = 0;
        } else {
            rear = (rear - 1 + capacity) % capacity;
        }

        size--;
        return Integer.toString(removedValue);
    }

       public boolean isEmpty() {
        return size == 0;
    }

      public boolean isFull() {
        return size == capacity;
    }
}

public class ImplementDeQue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); 
        scanner.nextLine(); 

        Deque deque = new Deque(T); 
        for (int i = 0; i < T; i++) {
            String operation = scanner.nextLine();
            String[] parts = operation.split(" ");
            String command = parts[0];

            switch (command) {
                case "push_front":
                    int x = Integer.parseInt(parts[1]);
                    deque.push_front(x);
                    break;
                case "push_back":
                    x = Integer.parseInt(parts[1]);
                    deque.push_back(x);
                    break;
                case "pop_front":
                    String result_front = deque.pop_front();
                    System.out.println(result_front);
                    break;
                case "pop_back":
                    String result_back = deque.pop_back();
                    System.out.println(result_back);
                    break;
                default:
                    break;
            }
        }

        scanner.close();
    }
}
