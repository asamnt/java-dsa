package com.gfg.dsa.arrays;

import java.util.HashSet;

public class TwoNumberSum {

    public static void main(String[] args) {
        int arr[] = new int[6], n = 6;
        arr[0] = 5;
        arr[1] = 8;
        arr[2] = 0;
        arr[3] = 23;
        arr[4] = -8;
        arr[5] = 12;

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println("Printing the solution");
        int[] solutionArray = twoNumberSumNaive(arr, 15);
        for (int i = 0; i < solutionArray.length; i++) {
            System.out.println(solutionArray[i]);
        }

        System.out.println("Printing the efficient solution");
        solutionArray = twoNumberSumEfficient(arr, 15);
        for (int i = 0; i < solutionArray.length; i++) {
            System.out.println(solutionArray[i]);
        }

    }

    // time O(n sqr)
    // space O(1)
    private static int[] twoNumberSumNaive(int[] arr, int targetSum) {
        for (int i = 0; i < arr.length; i++) { // loop for each element
            int firstNum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {// compare with every other remaining element
                int secondNum = arr[j];
                if (firstNum + secondNum == targetSum) {
                    return new int[] { firstNum, secondNum };
                }
            }
        }
        return new int[0];
    }

    // time O(n)
    // space O(n)
    private static int[] twoNumberSumEfficient(int[] arr, int targetSum) {
        HashSet<Integer> nums = new HashSet<>();// create hashset
        for (int num : arr) {// loop once
            int potentialMatch = targetSum - num; // find potential match
            if (nums.contains(potentialMatch)) { // check if potential match in hashset
                return new int[] { num, potentialMatch };
            } else {
                nums.add(num);// if potential match not present, just add the element to the hashset..because
                              // it could be potential match for some other number
            }
        }
        return new int[0];
    }

}
