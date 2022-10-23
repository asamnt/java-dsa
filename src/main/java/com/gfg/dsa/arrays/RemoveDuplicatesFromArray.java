package com.gfg.dsa.arrays;

public class RemoveDuplicatesFromArray {
    public static void main(String[] args) {
        int arr[] = new int[10], cap = 10, n=10;
        arr[0] = 5; arr[1]=5; arr[2]=24;
        arr[3] = 23; arr[4]=8; arr[5]=8;
        System.out.println("Before insertion");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]+" ");
        }

        int[] newarr = removeDuplicate(arr, 6);
        System.out.println("After removing duplicates");
        for (int i = 0; i < n; i++) {
            System.out.println(newarr[i]+" ");
        }
    }

    private static int[] removeDuplicate(int[] arr, int n) {
        int res = 1;
        for (int i = 1; i < n ; i++) {
            if (arr[i] != arr[res-1]){ //if current element is not equal to previous element, keep it
                arr[res] = arr[i];
                res++;
            }
        }
        return arr;
    }
}
