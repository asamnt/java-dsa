package com.gfg.dsa.stack.medium;

public class TwoStacksInOneArray {

    int[] arr;
    int cap, top1, top2;

    TwoStacksInOneArray(int n){
        cap = n;
        top1 = -1;
        top2 = n;
        arr = new int[n];
    }

    boolean push1(int x){
        if(top1 < top2 -1 ){//check if there is a slot available - essentially top1 is always less than top2
            top1++;
            arr[top1]= x;
            return true;
        }
        return false;
    }

    boolean push2(int x){
        if(top1 < top2 -1 ){//check if there is a slot available - essentially top1 is always less than top2
            top2--;
            arr[top2]= x;
            return true;
        }
        return false;
    }

    Integer pop1(){
        if(top1 > 0){
            int x = arr[top1];
            top1--;
            return x;
        }
        return null;
    }

    Integer pop2(){
        if(top2 < cap){
            int x = arr[top2];
            top2++;
            return x;
        }
        return null;
    }

    int size1(){
        return top1+1;
    }

    int size2(){
        return cap-top2;
    }


    public static void main(String[] args) {

    }


}
