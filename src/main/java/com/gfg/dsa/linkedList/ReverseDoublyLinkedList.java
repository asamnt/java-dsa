package com.gfg.dsa.linkedList;

public class ReverseDoublyLinkedList {

    public static void main(String[] args) {
        NodeDL head = new NodeDL(10);
        NodeDL temp1 = new NodeDL(20);
        NodeDL temp2 = new NodeDL(30);
        NodeDL temp3 = new NodeDL(40);

        head.next = temp1;
        temp1.prev = head;
        temp1.next = temp2;
        temp2.prev = temp1;
        temp2.next = temp3;
        temp3.prev = temp2;

        printlist(head);
        head = reverseDL(head);
        printlist(head);
    }

    static void printlist(NodeDL head){
        NodeDL curr=head;
        while(curr!=null){
            System.out.print(curr.data + " ");
            curr=curr.next;
        }
        System.out.println();
    }

    private static NodeDL reverseDL(NodeDL head) {


        NodeDL temp = null;
        NodeDL curr = head;
        while(curr!=null){
            temp = curr.prev;//store the previous pointer in temporary variable
            curr.prev = curr.next;//move the prev pointer to the node pointed by the next pointer
            curr.next = temp;//move the next pointer to the node pointed by previous pointer(stored in temp variable)

            //iterate to the next node
            curr = curr.prev;//instead of going curr.next we go curr.prev as we have already switched pointers
        }
        if(temp!=null){
            head = temp.prev;//temp will be the second node, so its previous will be the head
        }
        return head;

    }


}
