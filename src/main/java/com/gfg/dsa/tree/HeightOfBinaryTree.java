package com.gfg.dsa.tree;

//Height of Binary Tree is the number of nodes between the longest path from root to leaf node(including the root and leaf node).
public class HeightOfBinaryTree {

    public static void main(String[] args) {

        Node root = createNode();
        System.out.println(getHeight(root));

    }

    private static Node createNode() {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        root.right.right.left = new Node(60);
        root.right.right.left.left = new Node(70);
        return root;
    }

    public static int getHeight(Node root){
        if(root == null){
            return 0;
        }else{
            return Math.max(getHeight(root.left),getHeight(root.right))+ 1;
        }

    }
}
