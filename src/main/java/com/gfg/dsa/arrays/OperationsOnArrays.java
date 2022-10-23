package com.gfg.dsa.arrays;

public class OperationsOnArrays {

    public static void main(String[] args) {
        int arr[] = new int[5], cap = 5, n=3;
        arr[0] = 5; arr[1]=8; arr[2]=20;
        System.out.println("Before insertion");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]+" ");
        }
        System.out.println("After insertion");
        int x = 16, pos = 2;
        n = insert(arr, n, x, cap, pos);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]+" ");
        }
        int indexOfItem = search(arr, n,45);
        System.out.println(indexOfItem);

    }

    //inserting at end is best case
    //time - O(1) best case O(n) - average case
    //dynamic array => insert at end is O(1) operations on average even if after n + 1 you need to copy to a new array
    //for real time ops dont use dynamic arrays
    private static int insert(int[] arr, int n, int x, int cap, int pos) {
        if(n == cap){
            return n;
        }
        int index = pos -1;//index is always position -1
        for (int i = n-1; i >= index ; i--) {
            //we are starting from the last index i.e n-1
            //and going up to >= index because we want to move the existing value at index also to the right
            arr[i+1]= arr[i];//we are shifting all elements to the right by 1
        }
        //after moving everything right,
        arr[index] = x;

        return n + 1;//increment size of array by 1
    }

    //time O(n)
    //binary search for sorted array is O(log n)
    private static int search(int arr[], int n, int x){
        for (int i = 0; i < n; i++) {
            if(arr[i] == x){
                return i;
            }
        }
        return -1;
    }

    //time O(n)
    private int delete(int arr[], int n, int x){
        //first find the element
        int i;
        for ( i = 0; i < n ; i++) {
            if (arr[i] == x) {
                break;
            }
        }
        if(i == n){//this means we are past the last element n-1
            return n; //element is not present so we just return the length of the existing array
        }
        //if it does not go in the above if, then we have found the element at index i
        for (int j = i; j < n-1; j++) {//to delete we are shifting elements to the left
            //we start from the index we found i
            arr[j] = arr[j + 1];
        }
        return n-1;//return array size reduced by 1
    }

    //getting ith element and updating ith element = O(1)
    //arrrays are cache friendly


}
