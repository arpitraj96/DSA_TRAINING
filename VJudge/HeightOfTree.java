package VJudge;

import java.util.Scanner;

public class HeightOfTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            BinaryTree bst = new BinaryTree();
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            for(int ele : arr){
                bst.insert(ele);
            }
            System.out.println(bst.height());
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
class BinaryTree{
    private TreeNode root;
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
}
