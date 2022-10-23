package com.gfg.dsa.arrays;

public class MoveZeroToEnd {

    public static void main(String[] args) {
        int arr[] = new int[6], cap = 6, n=6;
        arr[0] = 5; arr[1]=8; arr[2]=0;
        arr[3] = 23; arr[4]=-8; arr[5]=12;
        System.out.println("Before insertion");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]+" ");
        }

       int[] newArray = MoveZeroToEnd(arr, 6);
    //    System.out.println(res);
       System.out.println("After moving zeros to end");
        for (int i = 0; i < n; i++) {
            System.out.println(newArray[i]+" ");
        }
    }

    private static int[] MoveZeroToEnd(int[] arr, int n) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                //if you find a 0 then run another loop for remaining elements and swap with a non zero element
                for (int j = i + 1 ; j < arr.length; j++) {
                    if (arr[j] != 0) {//element is non zero - so swap
                        int temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                        
                    }
                }
                
            }
        }
        return arr;
    }

}
