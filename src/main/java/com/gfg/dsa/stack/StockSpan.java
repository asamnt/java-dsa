package com.gfg.dsa.stack;

import java.util.Stack;

public class StockSpan {


    public static void main(String[] args) {
        printSpanNaive(new int[]{18, 12, 14, 15, 8, 35});
        System.out.println("efficient solution");
        printSpanNaive(new int[]{18, 12, 14, 15, 8, 35});
    }

    //Naive solution
    public static void printSpanNaive(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int span = 1;
            for (int j = i - 1; j >= 0 && arr[j] <= arr[i]; j--) {
                span++;
            }
            System.out.println(span);
        }
    }

    public static void printSpanEfficient(int[] arr){
        Stack<Integer> s = new Stack<>();
        s.add(0);
        System.out.println(1+" ");
        for (int i = 1; i < arr.length; i++) {
           while(!s.isEmpty() && arr[s.peek()] <= arr[i]){//the current element is greater than the element at the top of the stack then pop the top element of the stack
               //keep poping till you find an element that is greater than the current element
               s.pop();
           }
           int span = s.isEmpty() ? i + 1: 1-s.peek();  //if the stack is now empty then this is the largest element so far so span will be index + 1
            //if the stack is not empty then the current top element of the stack is the closes previous greater element than the current element - so span will be index of current element - index of this previous greater element
           System.out.println(span+" ");
           s.push(i);
        }

    }



    //Span = if there is a greater elemenmt on left side => Index of current element - Index of closest greater element on left side
    //Span = if not greater element on left side => Index of current element + 1




}
