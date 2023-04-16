package com.gfg.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxInBinaryTree {

    public static void main(String[] args) {
        Node root = createNode();
        System.out.println(getMax(root));
        System.out.println(getMaxUsingQueue(root));

    }

    private static Node createNode() {
        Node root = new Node(10);
        root.left = new Node(200);
        root.right = new Node(30);
        root.left.left = new Node(45);
        root.left.right = new Node(55);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        root.right.right.left = new Node(60);
        root.right.right.left.left = new Node(70);
        return root;
    }

    //for a perfect tree - use recursion
    public static int getMax(Node root){
        if(root==null) return Integer.MIN_VALUE;
        else{
            return Math.max(Math.max(getMax(root.left) , getMax(root.right)), root.key);//get max between left and right children and then compare with current node value
        }
    }

    //for a skewed tree, use queue method
    public static int getMaxUsingQueue(Node root){
        if(root==null) return Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;
        Queue<Node> q = new LinkedList<Node>();//we create a queue
        q.add(root);//we add the root to the queue first
        while(!q.isEmpty()){
            Node currNode = q.poll();
            maxValue = Math.max(currNode.key, maxValue);
            if(currNode.left!=null)//then if the left node of the current node is not null then we push it to the queue
                q.add(currNode.left);
            if(currNode.right!=null)//then if the right node of the current node is not null then we push it to the queue
                q.add(currNode.right);
        }
        return maxValue;

    }
}
