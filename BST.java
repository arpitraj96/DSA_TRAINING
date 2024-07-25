import java.util.Scanner;

public class BST {
    public static void main(String[] args) {
        BinaryTree bst = new BinaryTree();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Select what you want\n1. Insert\n2. Inorder\n3. Preorder\n4. Postorder\n5. Display\n6. FindMin\n7. FindMax\n8. Height\n9. Search\n0. Exit\n");
            int choices = sc.nextInt();
            if(choices==1){
                System.out.print("Enter the element to insert: ");
                int ele = sc.nextInt();
                bst.insert(ele);
            }else if(choices==2){
                System.out.println("The Inorder Traversal of the tree is: ");
                bst.inorder();
            }else if(choices==3){
                System.out.println("The Preorder Traversal of the tree is: ");
                bst.preorder();
            }else if(choices==4){
                System.out.println("The Postorder Traversal of the tree is: ");
                bst.postorder();
            }else if(choices==5){
                bst.printTree();
            }else if(choices==6){
                bst.findMin();
            }else if(choices==7){
                bst.findMax();
            }else if(choices==8){
                int height = bst.height();
                System.out.println("Height of the BST is: "+height);
            }else if(choices==9){
                System.out.print("Enter the element you want to search: ");
                int ele = sc.nextInt();
                bst.search(ele);
            }else if(choices==0){
                bst.printTree();
                System.out.println("Terminating.....");
                break;
            }else{
                System.out.println("Invalid Choice");
            }
        }
        sc.close();
    }
}
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    // Method to insert a node in the binary tree
    public void insert(int data) {
        this.root = insertRecursive(this.root, data);
    }

    public void inorder() {
        inorderRecursive(this.root);
        System.out.println(); 
    }
    public void preorder() {
        preorderRecursive(this.root);
        System.out.println(); 
    }
    public void postorder() {
        postorderRecursive(this.root);
        System.out.println(); 
    }
    public void findMin() {
        int ans = findMin(this.root);
        System.out.println(ans); 
        System.out.println();
    }
    public void findMax() {
        int ans = findMax(this.root);
        System.out.println(ans); 
        System.out.println(); 
    }
    public void search(int key) {
        if (searchRecursive(this.root, key)) {
            System.out.println("Element " + key + " is present in the BST.");
        } else {
            System.out.println("Element " + key + " is not present in the BST.");
        }
    }
    
    private boolean searchRecursive(TreeNode node, int key) {
        if (node == null) {
            return false;
        }
        if (node.data == key) {
            return true;
        }
        if (key < node.data) {
            return searchRecursive(node.left, key);
        } else {
            return searchRecursive(node.right, key);
        }
    }
    // Recursive method to insert a node in the binary tree
    private TreeNode insertRecursive(TreeNode node, int data) {
        if (node == null) {
            node = new TreeNode(data);
        } else {
            if (data <= node.data) {
                node.left = insertRecursive(node.left, data);
            } else {
                node.right = insertRecursive(node.right, data);
            }
        }
        return node;
    }

    // Method to calculate the height of the binary tree
    public int height() {
        return calculateHeight(this.root);
    }

    private void inorderRecursive(TreeNode node) {
        if (node != null) {
            inorderRecursive(node.left);
            System.out.print(node.data + " ");
            inorderRecursive(node.right);
        }
    }
    private void preorderRecursive(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderRecursive(node.left);
            preorderRecursive(node.right);
        }
    }
    private void postorderRecursive(TreeNode node) {
        if (node != null) {
            postorderRecursive(node.left);
            postorderRecursive(node.right);
            System.out.print(node.data + " ");
        }
    }
    private int findMin(TreeNode node) {
        if(node==null)
            return -1;
        while (node.left!=null) {
            node = node.left;
        }
        return node.data;
    }
    private int findMax(TreeNode node) {
        if(node==null)
            return -1;
        while (node.right!=null) {
            node = node.right;
        }
        return node.data;
    }

    // Recursive method to calculate the height of the binary tree
    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = calculateHeight(node.left);
            int rightHeight = calculateHeight(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    // Method to print the binary tree with dashes, arrows, and spaces
    public void printTree() {
        if (this.root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        printTreeRecursive(this.root, "");
    }

    // Recursive method to print the binary tree with dashes, arrows, and spaces
    private void printTreeRecursive(TreeNode node, String indent) {
        if (node == null) {
            System.out.println(indent + "- null");
            return;
        }

        // Print current node
        System.out.println(indent + "- " + node.data);

        // Recursive call for right subtree
        printTreeRecursive(node.right, indent + "   |");

        // Recursive call for left subtree
        printTreeRecursive(node.left, indent + "   ");
    }
}