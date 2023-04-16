package com.gfg.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

//max nodes present at any level
public class MaxWidthOfBinaryTree {

    public static void main(String[] args) {
        Node root = createNode();
        System.out.println(getMaxWidth(root));

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

    public static int getMaxWidth(Node root){
        if(root == null) return 0;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        int result = 0;
        while(!q.isEmpty()){
            int count = q.size();//this count gives you the current levels number of nodes - check this with the current result(max nodes)
            result = Math.max(result, count);//if no of nodes at current level greater than previous result, update the result
            for (int i = 0; i < count ; i++) {
                Node currNode = q.poll();
                if(currNode.left!=null) q.add(currNode.left);
                if(currNode.right!= null) q.add(currNode.right);
            }
        }
        return result;
    }
}
