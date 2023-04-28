package com.gfg.dsa.linkedList;

public class FindNthNodeFromEndOfLinkedList {

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;

        printNthNodeFromEnd(head, 3);
    }

    static void printlist(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data + " ");
            curr=curr.next;
        }
        System.out.println();
    }

    public static void printNthNodeFromEnd(Node head, int n){
        if(head==null) return;

        Node firstPointer = head;
        for (int i = 0; i < n ; i++) {//we let the firstPointer traverse till the nth node
            firstPointer = firstPointer.next;
        }
        //then assign a second pointer to head - this means the difference between first pointer and second is 'n'
        //so when the first pointer reaches the end, the second pointer would be n distance behind and that is the node we are looking for
        Node secondPointer = head;
        while(firstPointer!=null){
            secondPointer = secondPointer.next;
            firstPointer = firstPointer.next;
        }
        System.out.println(secondPointer.data);

    }

}
