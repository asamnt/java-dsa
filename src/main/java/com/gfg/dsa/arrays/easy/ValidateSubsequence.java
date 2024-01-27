package com.gfg.dsa.arrays.easy;

public class ValidateSubsequence {

    public static void main(String[] args) {
        int arr[] = new int[] { 5, 1, 22, 25, 6, -1, 8, 10 };
        int seq[] = new int[] { 1, 6, -1, 10 };
        // arr[0] = 5; arr[1]=8; arr[2]=0;
        // arr[3] = 23; arr[4]=-8; arr[5]=12;
        // //[5, 1, 22, 25, 6, -1, 8, 10]
        // //[1, 6, -1, 10]
        // for (int i = 0; i < n; i++) {
        // System.out.println(arr[i]+" ");
        // }
        boolean isSubsequencePresent = validateSubSequenceUsingWhileLoop(arr, seq);
        System.out.println(isSubsequencePresent);
        isSubsequencePresent = validateSubSequenceUsingForLoop(arr, seq);
        System.out.println(isSubsequencePresent);

    }

    public static boolean validateSubSequenceUsingWhileLoop(int[] arr, int[] seq) {
        int arrIndex = 0, seqIndex = 0;
        while (arrIndex < arr.length && seqIndex < seq.length) {// while loop till we reach end of both the arrays
            if (arr[arrIndex] == seq[seqIndex]) {// check if element in sequence array found in main array
                seqIndex++;// if the element was found, move to the next element in the sequence
            }
            arrIndex++;// if you found the element or not, just increment the main array index
        }
        if (seqIndex == seq.length) {// this means that all the elements in seq arr are in givn arr
            return true;
        } else {
            return false;
        }
    }

    public static boolean validateSubSequenceUsingForLoop(int[] arr, int[] seq) {
        int seqIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (seqIndex == seq.length) {
                break;
            }
            if (seq[seqIndex] == arr[i]) {
                seqIndex++;
            }
        }
        return seqIndex == seq.length;
    }
}
