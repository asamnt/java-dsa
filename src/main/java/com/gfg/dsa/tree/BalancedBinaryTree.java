package com.gfg.dsa.tree;

//difference between the heights of left subtree and right tree should not be more than 1 - and this should be true for every node
public class BalancedBinaryTree {

    public static void main(String[] args) {
        Node root = createNode();
        System.out.println(isBalanced(root));
        System.out.println("efficient solution");
        System.out.println(isBalancedEfficient(root));
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

    public static int getHeight(Node root){
        if(root == null){
            return 0;
        }else{
            return Math.max(getHeight(root.left),getHeight(root.right))+ 1;
        }
    }

    //naive solution
    //Time complexity O(n2)
    public static boolean isBalanced(Node root){
        if(root == null) return true;
        int height1 = getHeight(root.left);
        int height2 = getHeight(root.right);
        return (Math.abs(height1-height2) < 1 &&
                isBalanced(root.left) && //we recursively check if the children are balanced as well and if they are then check the height difference that should be less than 1
                isBalanced(root.right)
                );
    }

    //efficient solution
    public static int isBalancedEfficient(Node root){
        if(root == null) return 0;
        int height1 = isBalancedEfficient(root.left);//if height is -1 , it indicates tree is not balance, other it will give height of tree
        if(height1 == -1) return -1;
        int height2 = isBalancedEfficient(root.right);//if height is -1 , it indicates tree is not balance, other it will give height of tree
        if(height2 == -1) return -1;
        if(Math.abs(height1-height2) > 1) return -1;
        else{
            return Math.max(height1, height2) + 1;
        }

    }



}
