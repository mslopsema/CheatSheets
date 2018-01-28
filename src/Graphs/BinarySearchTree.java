package Graphs;

import java.util.LinkedList;
import java.util.Scanner;

import utils.TreeNode;
//import utils.TestTools;

public class BinarySearchTree {
    public static void main(String[] args) {
        System.out.print("Input Size : ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.close();
        
        int[] arr = {};//TestTools.randomArray(size, size);
        BinarySearchTree bst = new BinarySearchTree(size / 2);
        for (int i : arr) bst.add(i);
        System.out.println("Size : " + bst.size() + " Height : " + bst.height());
        //for (int i = 0; i < size; i++)
        //    System.out.println("[" + i + "] " + bst.search(i));
        bst.print();
    }
    
    class node {
        node left;
        node right;
        int val;
        node(int val) {this.val = val;}
    }
    
    private node root;
    
    BinarySearchTree(int val) {
        root = new node(val);
    }
    
    public void add(int val) {
        add(root, val);
    }
    
    private node add(node root, int val) {
        if (root == null) return new node(val);
        if (val == root.val) return null; //Don't add anything if the node already exists.
        if (val < root.val) root.left = add(root.left, val);
        if (val > root.val) root.right = add(root.right, val);
        return root;
    }
    
    public boolean search(int val) {
        return search(root, val);
    }
    
    private boolean search(node root, int val) {
        if (root == null)    return false;
        if (val == root.val) return true;
        if (val  < root.val) return search(root.left,  val);
        if (val  > root.val) return search(root.right, val);
        return false;
    }
    
    public int size() {
        return sum(root);
    }
    
    private int sum(node root) {
        if (root == null) return 0;
        return 1 + sum(root.left) + sum(root.right);
    }
    
    public int height() {
        return height(root);
    }
    
    private int height(node root) {
        if (root == null) return 0;
        int left  = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left,  right);
    }
    
    public void print() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        inOrderTraversal(root, list);
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (!list.isEmpty()) {
            sb.append(',');
            sb.append(list.removeFirst());
        }
        sb.deleteCharAt(1);
        sb.append(']');
        System.out.println(sb.toString());
    }
    
    private void inOrderTraversal(node root, LinkedList<Integer> list) {
        if (root == null) return;
        inOrderTraversal(root.left, list);
        list.addLast(root.val);
        inOrderTraversal(root.right, list);
    }
}
