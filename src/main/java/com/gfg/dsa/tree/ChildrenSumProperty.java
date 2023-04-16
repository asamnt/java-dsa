package com.gfg.dsa.tree;

public class ChildrenSumProperty {

    public static void main(String[] args) {
        Node root = createNode();
        System.out.println(isChildrenSumProperty(root));
    }

    private static Node createNode() {
        Node root = new Node(30);
        root.left = new Node(20);
        root.right = new Node(10);
//        root.left.left = new Node(45);
//        root.left.right = new Node(55);
//        root.right.left = new Node(40);
//        root.right.right = new Node(50);
//        root.right.right.left = new Node(60);
//        root.right.right.left.left = new Node(70);
        return root;
    }

    public static boolean isChildrenSumProperty(Node root){
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        int sum = 0;
        if(root.left!=null) sum = sum + root.left.key;
        if(root.right!=null) sum = sum + root.right.key;

        return root.key==sum && isChildrenSumProperty(root.left) && isChildrenSumProperty(root.right);
    }
}
