package com.gfg.dsa.arrays;

public class LargestElementInArray {

    public static void main(String[] args) {
        int arr[] = new int[5], n = 3;
        arr[0] = 5;
        arr[1] = 8;
        arr[2] = 20;
        System.out.println("Before insertion");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }

        int res = getLargest(arr, 3);
        System.out.println(res);
    }

    private static int getLargest(int arr[], int n) {
        int largest = 0; // assume first index in array contains the largest element
        for (int i = 1; i < n; i++) {
            // if value at current index is greater than value at existing largest index,
            // then replace the largest index with current index
            if (arr[largest] < arr[i]) {
                largest = i;
            }
        }
        return largest;
    }
}
