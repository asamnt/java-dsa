package com.gfg.dsa.tree;

public class SizeOfBinaryTree {

    public static void main(String[] args) {
        Node root = createNode();
        System.out.println(getSize(root));

    }

    private static Node createNode() {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(45);
        root.left.right = new Node(55);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        root.right.right.left = new Node(60);
        root.right.right.left.left = new Node(70);
        return root;
    }

    public static int getSize(Node root){
        if(root==null) return 0;
        else{
            return getSize(root.left) + getSize(root.right) + 1;
        }
    }
}
