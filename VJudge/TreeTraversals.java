package VJudge;

import java.util.Scanner;

public class TreeTraversals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            BinaryTree bst = new BinaryTree();
            int n = sc.nextInt();
            for(int i=0; i<n; i++){
                int ele = sc.nextInt();
                bst.insert(ele);
            }
            bst.preorder();
            bst.inorder();
            bst.postorder();
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
}