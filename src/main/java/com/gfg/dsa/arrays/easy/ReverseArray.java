package com.gfg.dsa.arrays.easy;

public class ReverseArray {
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

        int[] newarr = reverse(arr, 6);
        System.out.println("After reversing");
        for (int i = 0; i < n; i++) {
            System.out.println(newarr[i] + " ");
        }
    }

    private static int[] reverse(int[] arr, int n) {
        // we will use a while loop
        int low = 0, high = n - 1;
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        return arr;
    }

}
