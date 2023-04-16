package com.gfg.dsa.tree;

public class NodesAtKDistance {


    public static void main(String[] args) {
        Node root = createNode();
        printKthNode(root, 2);
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

    public static void printKthNode(Node root, int k){
        if(root == null) return;
        if(k==0)//this means we have travelled k distance and we can now print the value of the node
            System.out.println(root.key+" ");
        else{
            printKthNode(root.left, k-1);//we reduce the distance to travel by 1 as we are going 1 level down and the distance remaining to travel is hence k-1
            printKthNode(root.right, k-1);
        }
    }
}
