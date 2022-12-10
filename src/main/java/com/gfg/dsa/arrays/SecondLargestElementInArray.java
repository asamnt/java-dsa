package com.gfg.dsa.arrays;

public class SecondLargestElementInArray {

    public static void main(String[] args) {
        int arr[] = new int[10], n = 10;
        arr[0] = 5;
        arr[1] = 8;
        arr[2] = 24;
        arr[3] = 23;
        arr[4] = -8;
        arr[5] = 12;
        System.out.println("Before insertion");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }

        int res = getSecondtLargest(arr, 6);
        System.out.println(res);
    }

    private static int getSecondtLargest(int arr[], int n) {
        int secondLargest = -1, largest = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[largest]) {
                // if element at new index in stream is greater than largest element index
                // move current largest index to second largest index
                // move new element index to largest index
                secondLargest = largest;
                largest = i;
            } else if (arr[i] != arr[largest]) {
                // if element at new index is less than largest but greater than second largest
                // or if we have not yet found second largest
                if (arr[i] > arr[secondLargest] || secondLargest == -1) {
                    secondLargest = i;
                }
            } // else ignore if it equal

        }

        return secondLargest;

    }
}
