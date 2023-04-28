package com.gfg.dsa.linkedList;

public class DoublyLinkedListOperations {


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
        head = insertBegin(head, 45);
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

    public static NodeDL insertBegin(NodeDL head, int data){
        NodeDL temp = new NodeDL(data);
        temp.next = head;
        if(head!=null)
            head.prev = temp;
        return temp;
    }
}
