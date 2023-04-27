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
    }
}
