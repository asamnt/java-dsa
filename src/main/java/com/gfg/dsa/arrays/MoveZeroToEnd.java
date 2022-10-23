package com.gfg.dsa.arrays;

public class MoveZeroToEnd {

    public static void main(String[] args) {
        int arr[] = new int[10], cap = 10, n=10;
        arr[0] = 5; arr[1]=8; arr[2]=24;
        arr[3] = 23; arr[4]=-8; arr[5]=12;
        System.out.println("Before insertion");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]+" ");
        }

//        boolean res = isSorted(arr, 6);
//        System.out.println(res);
    }

}
