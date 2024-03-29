package com.gfg.dsa.stack;

import java.util.Stack;

public class PreviousGreaterElement {

    public static void main(String[] args) {
        printPrevGreater(new int[]{18, 12, 14, 15, 8, 35});
    }

    public static void printPrevGreater(int[] arr){
        Stack<Integer> s = new Stack<>();
        s.add(arr[0]);//add the first element to the stack by default
        System.out.println(-1+" ");
        for (int i = 1; i < arr.length; i++) {
            while(!s.isEmpty() && s.peek() <= arr[i]){//the current element is greater than the element at the top of the stack then pop the top element of the stack
                //keep poping till you find an element that is greater than the current element
                s.pop();
            }
            int prevGreater = s.isEmpty() ? -1: s.peek();  //if the stack is now empty then this is the largest element so far so span will be index + 1
            //if the stack is not empty then the current top element of the stack is the closes previous greater element than the current element - so span will be index of current element - index of this previous greater element
            System.out.println(prevGreater+" ");
            s.push(arr[i]);
        }

    }

}
