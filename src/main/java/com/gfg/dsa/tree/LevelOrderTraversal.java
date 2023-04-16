package com.gfg.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        Node root = createNode();
        printLevel(root);
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

    public static void printLevel(Node root){

        if(root==null) return;
        Queue<Node> q = new LinkedList<Node>();//we create a queue
        q.add(root);//we add the root to the queue first
        while(!q.isEmpty()){
            //queue picks up element FIFO mode and so we push the immediate children first, so we get them out also first
            //this means the children at higher level will be processed first and then children at lower level
            Node currNode = q.poll();//we take out the first element in the queue and print it
            System.out.println(currNode.key+" ");
            if(currNode.left!=null)//then if the left node of the current node is not null then we push it to the queue
                q.add(currNode.left);
            if(currNode.right!=null)//then if the right node of the current node is not null then we push it to the queue
                q.add(currNode.right);
        }


    }
}
