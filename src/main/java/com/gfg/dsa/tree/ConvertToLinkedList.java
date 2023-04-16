package com.gfg.dsa.tree;

public class ConvertToLinkedList {

    static Node prev = null;

    public static void main(String[] args) {
        Node root = createNode();
        Node head = convertToLinkedList(root);
        printlist(head);

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

    private static Node convertToLinkedList(Node root) {
        if(root==null) return root;
        //we are doing inorder traversal - means left, root, right
        //we convert each node left node and right node to
        //traverse left node
        Node head = convertToLinkedList(root.left);
        //process root
        //if previous pointer is null(initialized as null), (this means we are yet to process the first leaf node) - that means you have ther head of your linked list
        if(prev == null) head = root;//this happens only once when the left most node is visited
        else{
            //this is the main processing
            //keep track of previous and then assign the root left to prev and then the previous right as root - connect them together
            root.left = prev;
            prev.right = root;
        }
        prev=root;//then move the prev pointer to the root
        //traverse right node
        convertToLinkedList(root.right);
        return head;
    }

    public static void printlist(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.key+" ");
            curr=curr.right;
        }
    }


}
