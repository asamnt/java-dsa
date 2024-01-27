package com.gfg.dsa.arrays.hard;

public class TrappingRainWater {

    public static void main(String[] args) {
        // int arr[] = new int[] { 3, 0, 1, 2, 5 };
        // int arr[] = new int[] { 5, 4, 3 };
        int[] arr = new int[] { 8, 1, 7, 2, 6, 8 };

        int result = findMaxWaterTrapperNaive(arr);
        System.out.println("Water than be stored is " + result);
        result = findMaxTrappedWaterEfficient(arr);
        System.out.println("Water than be stored is " + result);

    }

    private static int findMaxTrappedWaterEfficient(int[] arr) {
        int result = 0;
        int[] lMax = new int[arr.length];
        int[] rMax = new int[arr.length];// we are trying to pre compute lMax and rMax arrays
        // pre computing lMax array
        lMax[0] = arr[0]; // we assign the lMax for the first element the first element itself
        for (int i = 1; i < arr.length; i++) {// we go from the second element to the last element
            lMax[i] = lMax[i - 1] > arr[i] ? lMax[i - 1] : arr[i];
            // we compare the current element with the lMax of the
            // previous element, whichever is bigger is the lMax
            // of the current element
        }

        // pre computing the rMax array
        rMax[arr.length - 1] = arr[arr.length - 1];// we assign the rMax for the last element as the last element itself
        for (int j = arr.length - 2; j > 0; j--) {
            // reverse loop - we go from the second last element to the first
            // element
            rMax[j] = rMax[j + 1] > arr[j] ? rMax[j + 1] : arr[j];
            // we compare the current element with the rMax of the
            // previous element, whichever is bigger is the rMax
            // of the current element
        }

        for (int i = 1; i < arr.length - 1; i++) {// we loop leaving the first and the last element
            result = result + Math.min(lMax[i], rMax[i]) - arr[i];
        }

        return result;
    }

    // Time complexity O(n2)
    private static int findMaxWaterTrapperNaive(int[] arr) {

        int result = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            // we loop leaving the first and the last elements as we cannot store
            // water on those elements
            // we need to find the left highest wall and the right highest wall for the
            // current wall, because max water can be trapped between those two walls

            int lMax = arr[i];// we assign the left most element as the largest element
            for (int j = 0; j < i; j++) {// loop from the left most element to the current element
                lMax = lMax > arr[j] ? lMax : arr[j];// if there is any element is greater than lMax , we assign that as
                                                     // lMax
            }
            int rMax = arr[i];// similar to above we find the rMax
            for (int j = i + 1; j < arr.length; j++) {// we loop from next element of current element till the last
                                                      // element
                rMax = rMax > arr[j] ? rMax : arr[j];
            }
            // once we find the lMax and rMax for the current element, we can find the water
            // that can be trapped at the current element
            result = result + (lMax > rMax ? rMax : lMax) - arr[i];
            // first we get the min of the lMax and rMax as that is how much water can be
            // trapper between the two walls, then we subtract arr[i] because we cannot
            // store water where the wall is present

        }

        return result;
    }

}
