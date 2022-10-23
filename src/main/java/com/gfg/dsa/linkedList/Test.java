package com.gfg.dsa.linkedList;

public class Test {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;

        System.out.println("printing iteratively");
        printLinkedList(head);
        System.out.println("printing using recursion");
        printLinkedListUsingRecursion(head);

        head = insertBegin(head,5);
        head = insertBegin(head, 4);
        System.out.println("printing after insert begin");
        printLinkedList(head);


        head = insertEnd(head,8);
        head = insertEnd(head, 9);
        System.out.println("printing after insert end");
        printLinkedList(head);

        deleteLast(head);
        System.out.println("print after delete");
        printLinkedList(head);

        insertAtPosition(head, 4, 39);
        System.out.println("print after insert at position");
        printLinkedList(head);

        int pos = search(head, 39);
        System.out.println("position of 39 is "+pos);

        pos = searchRecursive(head, 8);
        System.out.println("position of 8 is "+pos);


    }
    public static void printLinkedList(Node head){
        // traversing linked list
        //time complexity O(n)
        //no auxillary space required
        Node curr = head;
        while(curr != null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
    //using recursion
    //time O(n)
    //space O(n)
    public static void printLinkedListUsingRecursion(Node head){
        if (head == null){
            return;
        }
        System.out.println(head.data+" ");
        printLinkedListUsingRecursion(head.next);
    }
    //time : O(1)
    public static Node insertBegin(Node head, int x){
        Node temp = new Node(x);
        temp.next = head;
        return temp;//this becomes the new head
    }
    public static Node insertEnd(Node head, int x){
        Node temp = new Node(x);
        if (head == null){
            return temp;
        }
        Node curr = head;
        while (curr.next != null){ // this means we are the last node
            curr = curr.next;
        }
        curr.next = temp;
        return head;//we return the same head
    }

    public static Node deleteFirst(Node head){
        if(head == null){
            return null;
        }
        return head.next;
    }

    public static Node deleteLast(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node curr = head;
        while(curr.next.next != null){
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }

    public static Node insertAtPosition(Node head, int pos, int x){

        Node temp = new Node(x);
        if(pos ==1){ //change the head and return the modified head
            temp.next = head;
            return temp;//new head
        }
        Node curr = head;
        for(int i=0; i <= pos-2 && curr != null; i++){//loop through till you reach the previous node position
            curr = curr.next;
        }
        if (curr == null){//we do not have that position in the list
            return head;
        }
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }

    public static int search(Node head, int x){
        int pos = 1;
        Node curr = head;
        while (curr != null){
            if (curr.data == x){
                return pos;
            } else{
                pos++;
                curr = curr.next;
            }
        }
        return -1;
    }

    public static int searchRecursive(Node head, int x){
        if (head == null) {
            return -1;
        }
        if (head.data == x){
            //base case
            return 1;
        } else {
            //do recursive call
            int res = searchRecursive(head.next, x);
            if (res == -1){
                return -1;
            } else{
                return (res + 1);//the number of recursive calls plus 1 qill the location of the searched item
            }
        }
    }



}
