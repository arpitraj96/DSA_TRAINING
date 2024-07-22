import java.util.Scanner;
public class DoublyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        while (true) {
            System.out.println("\nSelect, What you want\n1. InsertAtBeginning\n2. InsertAtEnd\n3. Display\n4. DeleteAtBeginning\n5. DeleteAtEnd\n6. InsertAtPosition\n7. DeleteAtPosition\n0. Exit\n");
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
            }else if(choice==6){
                System.out.print("Enter a number into the list: ");
                int num = sc.nextInt();
                System.out.print("Enter Position: ");
                int pos = sc.nextInt();
                head = insertAtPos(num, pos, head);
            }else if(choice==7){
                System.out.print("Enter the position: ");
                int pos = sc.nextInt();
                head = deleteAtPos(pos, head);
            }else if(choice==0){
                display(head);
                System.out.println("Terminating.........");
                break;
            }else{
                System.out.println("Enter a valid Choice.");
            }
        }
        sc.close();
    }
    static Node insertAtBeg(int num, Node head){
        Node newNode = new Node(num);
        if(head!=null){
            head.prev=newNode;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }
    static Node insertAtEnd(int num, Node head){
        Node newNode = new Node(num);
        if(head==null){
            head = newNode;
        }else{
            Node temp = head;
            while (temp.next!=null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
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

            if(head!=null){
                head.prev = null;
            }
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
            while (last.next!=null) {
                last = last.next;
            }
            System.out.println("The deleted element is: "+last.data);
            // Node prev = last.prev;
            // prev.next = null;
            last.prev.next = null;
        }
        return head;
    }
    static Node insertAtPos(int num, int pos, Node head){
        Node newNode = new Node(num);
        if(pos<=0){
            System.out.println("Invalid Position");
        }else if(head==null){
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
        }else if(pos==1){
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
        }else{
            Node temp = head;
            for(int i=1; i<=pos-2; i++){
                temp = temp.next;
                if(temp==null){
                    System.out.println("Position beyond the list");
                    return head;
                }
            }
            newNode.prev = temp;
            if(temp.next!=null){
                newNode.next = temp.next;
                temp.next.prev = newNode;
                temp.next = newNode;
            }else{
                temp.next = newNode;
                newNode.next = null;
            }
        }
        return head;
    }
    static Node deleteAtPos(int pos, Node head){
        if(head==null){
            System.out.println("List is Empty");
        }else if(pos<=0){
            System.out.println("Invalid Position");
        }else if(pos==1){
            System.out.println("The deleted element is: "+head.data);
            if(head.next!=null){
                head = head.next;
                head.prev = null;
            }else{
                head = null;
            }
        }else{
            Node last = head;
            for(int i=1; i<=pos-1; i++){
                last = last.next;
                if(last==null){
                    System.out.println("Position beyond the list");
                    return head;
                }
            }
            System.out.println("The deleted element is: "+last.data);
            last.prev.next= last.next;
            if(last.next!=null){
                last.next.prev = last.prev;
                last.next = null;
                last.prev = null; 
            }else{
                last.next = null;
                last.prev = null;
            }
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
    Node prev;
    Node(int num){
        data = num;
        next = null;
        prev = null;
    }
}