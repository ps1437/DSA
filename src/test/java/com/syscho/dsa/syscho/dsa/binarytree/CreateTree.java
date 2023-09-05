package com.syscho.dsa.binarytree;

import java.util.Scanner;

public class CreateTree {

    public static void main(String[] args) {
        Node root = createTree();
        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
    }

    private static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getData() + " ");
    }

    private static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    private static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        inOrder(root.getRight());
    }

    private static Node createTree() {

        Scanner sc = new Scanner(System.in);

        Node root = null;
        System.out.println("Enter data: ");
        int data = sc.nextInt();
        if (data == -1) return null;
        root = new Node(data);
        System.out.println("Enter left for " + data);
        root.setLeft(createTree());

        System.out.println("Enter right for " + data);
        root.setRight(createTree());
        return root;
    }

    private static Node createNode(int data) {
        return new Node(data);
    }
}
