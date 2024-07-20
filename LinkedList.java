import java.util.Scanner;
class LinkedList {
    public static void main(String[] args) {
        Node head = null;
        while (true) {
            System.out.println("Select, What you want\n1. InsertAtBeginning\n2. InsertAtEnd\n3. Display\n4. DeleteAtBeginning\n5. DeleteAtEnd\n0. Exit\n");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if(choice==1){
                System.out.print("Enter a number into the list: ");
                int num = sc.nextInt();
                head = insertAtBeg(num, head);
            }else if(choice==3){
                display(head);
            }else if(choice==4){
                head = deleteAtBeginning(head);
            }else if(choice==2){
                System.out.print("Enter a number into the list: ");
                int num = sc.nextInt();
                head = insertAtEnd(num, head);
            }else if(choice==5){
                head = deleteAtEnd(head);
            }else if(choice==0){
                display(head);
                System.out.println("Terminating.........");
                break;
            }else{
                System.out.println("Enter a valid Choice.");
            }
            // sc.close();
        }
    }
    static Node insertAtBeg(int num, Node head){
        Node newNode = new Node(num);
        newNode.next = head;
        head = newNode;
        return head;
    }
    static Node insertAtEnd(int num, Node head){
        Node newNode = new Node(num);
        if(head==null){
            newNode.next = head;
            head = newNode;
        }else{
            Node temp = head;
            while (temp.next!=null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return head;
    }
    static Node deleteAtBeginning(Node head){
        if(head==null){
            System.out.println("List is empty");
        }else{
            System.out.println("The deleted element is: "+head.data);
            Node temp = head;
            head = head.next;
            temp.next = null;
        }
        return head;
    }
    static Node deleteAtEnd(Node head){
        if(head==null){
            System.out.println("List is empty");
        }else if(head.next==null){
            System.out.println("The deleted element is: "+head.data);
            head = null;
        }else{
            Node last = head;
            Node last2 = head;
            while (last.next!=null) {
                last2 = last;
                last = last.next;
            }
            System.out.println("The deleted element is: "+last.data);
            last2.next = null;
        }
        return head;
    }
    static void display(Node head){
        if(head==null)
            System.out.println("List is Empty");
        else{
            Node temp = head;
            while (temp!=null) {
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
}

class Node {
    int data;
    Node next;
    Node(int num){
        data = num;
        next = null;
    }
}