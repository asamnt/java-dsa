package com.gfg.dsa.stack.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        ArrayList<Integer> printSequence = printNextGreater(new int[]{18, 12, 14, 15, 8, 35});
        Collections.reverse(printSequence);
        System.out.println(printSequence);
    }

    public static ArrayList<Integer> printNextGreater(int[] arr){
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> printSequence = new ArrayList<>();
        int n = arr.length-1;
        s.add(arr[n]);//add the last element to the stack by default
        System.out.println(-1+" ");
        printSequence.add(-1);
        for (int i = n-1; i >= 0; i--) {//for this we need to go in reverse order of the array
            while(!s.isEmpty() && s.peek() <= arr[i]){//the current element is greater than the element at the top of the stack then pop the top element of the stack
                //keep poping till you find an element that is greater than the current element
                s.pop();
            }
            int nextGreater = s.isEmpty() ? -1: s.peek();  //if the stack is now empty then this is the largest element so far so span will be index + 1
            //if the stack is not empty then the current top element of the stack is the closes previous greater element than the current element - so span will be index of current element - index of this previous greater element
            System.out.println(nextGreater+" ");
            printSequence.add(nextGreater);
            s.push(arr[i]);
        }
        return printSequence;

    }

}
