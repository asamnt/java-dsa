package com.gfg.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLeftView {

    public static void main(String[] args) {
        Node root = createNode();
        printLeftView(root);
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

    //printing only the left node at each level
    public static void printLeftView(Node root){
        if(root==null) return;
        Queue<Node> q = new LinkedList<Node>();//we create a queue
        q.add(root);//we add the root to the queue first
        while(!q.isEmpty()){
            int count = q.size();
            for (int i = 0; i < count ; i++) {//we loop for all current elements in the queue
                Node currNode = q.poll();
                if(i==0){//this is the first element and hence the leftmost node so we print it - we dont print other nodes
                    System.out.print(currNode.key+" ");
                }
                if(currNode.left!=null)
                    q.add(currNode.left);
                if(currNode.right!=null)
                    q.add(currNode.right);
            }
        }
    }
}
