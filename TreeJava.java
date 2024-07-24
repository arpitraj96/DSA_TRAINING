import java.util.*;

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

    // Method to print the binary tree using level order traversal (BFS)
    public void printTree() {
        if (this.root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this.root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                System.out.print(currentNode.data + " ");

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            System.out.println(); // Move to the next level
        }
    }
}

public class TreeJava {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert nodes into the binary tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print the binary tree
        System.out.println("Binary Tree:");
        tree.printTree();
        
        // Calculate and print the height of the binary tree
        int height = tree.height();
        System.out.println("\nHeight of the binary tree: " + height);
    }
}
