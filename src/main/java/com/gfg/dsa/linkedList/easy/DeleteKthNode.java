package com.gfg.dsa.linkedList.easy;

import com.gfg.dsa.linkedList.easy.Node;

import static com.gfg.dsa.linkedList.easy.LinkedListOperations.deleteFirst;

public class DeleteKthNode {

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        printlist(head);
        head = deleteKthNode(head, 3);
        printlist(head);
    }

    private static Node deleteKthNode(Node head, int k) {
        if(head == null) return head;
        if(k==1) return deleteFirst(head);
        Node curr = head;
        for(int i=0; i < k-2; i++){//we traverse upto k-3 node
            curr = curr.next;
        }
        curr.next = curr.next.next;//we are skipping the kth node and linking to its next node
        return head;
    }

    static void printlist(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data + " ");
            curr=curr.next;
        }
        System.out.println();
    }
}
