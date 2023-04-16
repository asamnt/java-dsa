package com.gfg.dsa.tree;

class Node{
    int key;
    Node left;
    Node right;
    Node(int k){
        key = k;
        left=right=null;
    }
}

public class Traversal {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        System.out.println("printing inorder traversal");
        inorder(root);

        System.out.println("printing preorder traversal");
        preorder(root);

        System.out.println("printing postorder traversal");
        postorder(root);
    }

    //left root right
    public static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.println(root.key+" ");
            inorder(root.right);
        }
    }

    //root left right
    public static void preorder(Node root){
        if(root!=null){
            System.out.println(root.key+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    //left right root
    public static void postorder(Node root){
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.key+" ");

        }
    }

}
