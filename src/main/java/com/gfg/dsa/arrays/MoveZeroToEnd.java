package com.gfg.dsa.arrays;

public class MoveZeroToEnd {

    public static void main(String[] args) {
        int arr[] = new int[6], n = 6;
        arr[0] = 5;
        arr[1] = 8;
        arr[2] = 0;
        arr[3] = 23;
        arr[4] = -8;
        arr[5] = 12;
        System.out.println("Before insertion");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }

        // int[] newArray = moveZeroToEndMethod1(arr, 6);
        // // System.out.println(res);
        // System.out.println("After moving zeros to end");
        // for (int i = 0; i < n; i++) {
        // System.out.println(newArray[i]+" ");
        // }

        int[] newArray = moveZeroToEndMethod2(arr);
        // System.out.println(res);
        System.out.println("After moving zeros to end with method 2");
        for (int i = 0; i < n; i++) {
            System.out.println(newArray[i] + " ");
        }

    }

    private static int[] moveZeroToEndMethod1(int[] arr, int n) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                // if you find a 0 then run another loop for remaining elements and swap with a
                // non zero element
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] != 0) {// element is non zero - so swap
                        int temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;

                    }
                }

            }
        }
        return arr;
    }

    public static int[] moveZeroToEndMethod2(int[] array) {

        int count = 0;// this represents the index of the current 0 element
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                // we increment the count whenever we have non zero element
                // if we find a non-zero element, we swap with the current zero element which is
                // at index 'count'
                // if we have not found a zero element yet, the swap happens at the same index
                int temp = array[i];
                array[i] = array[count];
                array[count] = temp;
                count++;
            }
        }

        return array;

    }

}
