package com.gfg.dsa.arrays;

public class LeftRotateArrayByOne {
    public static void main(String[] args) {
        int arr[] = new int[6], cap = 6, n=6;
        arr[0] = 5; arr[1]=8; arr[2]=0;
        arr[3] = 23; arr[4]=-8; arr[5]=12;
        System.out.println("Before moving");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]+" ");
        }
        System.out.println("After rotation");
        int [] newArray = rotateByOne(arr);
        for (int i = 0; i < n; i++) {
            System.out.println(newArray[i]+" ");
        }
        System.out.println("After left rotation by d spaces naive solution");
        int d = 2;
        int[] newArray2 =leftRotateByD(newArray, d);
        for (int i = 0; i < n; i++) {
            System.out.println(newArray2[i]+" ");
        }

        System.out.println("After left rotation by d spaces efficient solution");
        d = 2;
        int[] newArray3 =leftRotateByDEfficient(newArray2, d);
        for (int i = 0; i < n; i++) {
            System.out.println(newArray3[i]+" ");
        }

        System.out.println("After left rotation by d spaces reversal solution");
        d = 2;
        int[] newArray4 =leftRotateByDEfficient(newArray3, d);
        for (int i = 0; i < n; i++) {
            System.out.println(newArray4[i]+" ");
        }


    }

    private static int[] rotateByOne(int[] arr) {
        int temp = arr[0];
        int n = arr.length;
        for (int i = 1; i < arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[n-1] = temp;
        return arr;
    }

    //time O(n * d)
    //space O(1)
    private static int[] leftRotateByD(int[] arr, int d){
        // Naive solution - you left rotate by one d times
        for (int i = 0; i < d; i++) {
            rotateByOne(arr);
        }
        return arr;
    }

    //efficient solution
    //time O(n)
    //space O(d)
    private static int[] leftRotateByDEfficient(int[] arr, int d){
        int[] temp = new int[d];

        //first copy d elements to new array
        for (int index = 0; index < d; index++) {
            temp[index] = arr[index];
        }
        //then move remaining elements(n-d) from index d till the end by d spaces
        for (int i = d; i < arr.length; i++) {
            arr[i-d] = arr[i];//moving d spaces back
        }
        //then copy the temp array elements 
        for (int i = 0; i < temp.length; i++) {//temp array has d elements so we loop d times
            arr[arr.length-d+i] = temp[i]; 
            //why n-d+1 =>
            //we have already moved the remaining n-d elements, so they are in their correct index from 0 to n-d-1
            //so we start filling the array from the next index of that i.e from (n-d+i) here i starts with 0
        }
        return arr;
    }

    public static int[] leftRotateByDReversal(int[] arr, int d) {

        int n = arr.length;
        reverseArray(arr, 0, d-1);
        reverseArray(arr, d, n-1);
        reverseArray(arr, 0, n-1);

        return arr;
        
    }



    private static int[] reverseArray(int[] arr, int low, int high){
        int temp;
        
        for (int i = 0; i < arr.length; i++) {
            temp = arr[low];
            arr[high] = arr[low];
            arr[low] = temp;
        }
        return arr;
    }
    
    
}

