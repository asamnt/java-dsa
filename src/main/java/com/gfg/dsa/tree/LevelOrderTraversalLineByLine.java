package com.gfg.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalLineByLine {

    public static void main(String[] args) {
        Node root = createNode();
        printLevelLineByLine(root);
        System.out.println("printing without marker");
        printLevelLineByLineWithoutMarker(root);
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

    //time complexity O(n)
    //aux space Theta(W)
    public static void printLevelLineByLine(Node root){

        if(root==null) return;
        Queue<Node> q = new LinkedList<Node>();//we create a queue
        q.add(root);//we add the root to the queue first
        q.add(null);//this is end of level marker
        while(q.size()>1){
            //queue picks up element FIFO mode and so we push the immediate children first, so we get them out also first
            //this means the children at higher level will be processed first and then children at lower level
            Node currNode = q.poll();//we take out the first element in the queue and print it
            if(currNode==null) {//if the queue element is null, that means end of level marker, and hence we need to print line,
                System.out.println();
                q.add(null);// and at the same time add another null marker because we now have all the next level children in the queue already
                continue;//skip the current loop- as we dont need to ao anything else
            }
            System.out.print(currNode.key+" ");
            if(currNode.left!=null)//then if the left node of the current node is not null then we push it to the queue
                q.add(currNode.left);
            if(currNode.right!=null)//then if the right node of the current node is not null then we push it to the queue
                q.add(currNode.right);
        }
    }
    public static void printLevelLineByLineWithoutMarker(Node root){
        if(root== null) return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            int count = q.size();
            for (int i = 0; i < count ; i++) {
                Node currNode = q.poll();
                System.out.print(currNode.key+" ");
                if(currNode.left!=null)
                    q.add(currNode.left);
                if(currNode.right!=null)
                    q.add(currNode.right);
            }
            System.out.println();
        }



    }
}
