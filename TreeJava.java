// import java.util.*;
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

    public void insert(int data) {
        this.root = insertRecursive(this.root, data);
    }
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
    public int height() {
        return calculateHeight(this.root);
    }
    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = calculateHeight(node.left);
            int rightHeight = calculateHeight(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    public void printTree() {
        if (this.root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        printTreeRecursive(this.root, "");
    }
    private void printTreeRecursive(TreeNode node, String indent) {
        if (node == null) {
            System.out.println(indent + "- null");
            return;
        }

        System.out.println(indent + "- " + node.data);

        printTreeRecursive(node.right, indent + "   |");

        printTreeRecursive(node.left, indent + "   ");
    }
}

public class TreeJava {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Binary Tree:");
        tree.printTree();

        int height = tree.height();
        System.out.println("\nHeight of the binary tree: " + height);
    }
}
