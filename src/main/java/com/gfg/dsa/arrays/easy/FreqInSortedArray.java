package com.gfg.dsa.arrays.easy;

public class FreqInSortedArray {
    public static void main(String[] args) {
        int arr[] = new int[] { 2, 2, 4, 4, 4, 7, 7, 7, 7, 7 };
        printFreqInSortedArrayNaive(arr);
    }

    // time complexity O(n)
    private static void printFreqInSortedArrayNaive(int[] arr) {
        int freq = 1;
        int idx = 1;
        while (idx < arr.length) {
            if (arr[idx - 1] == arr[idx]) {
                freq++;
                idx++;
            } else {
                System.out.println(arr[idx - 1] + " freq is " + freq);
                idx++;
                freq = 1;
            }
        }
        System.out.println(arr[idx - 1] + " freq is " + freq);
    }
}
