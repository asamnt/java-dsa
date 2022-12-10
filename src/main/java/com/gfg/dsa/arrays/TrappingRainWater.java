package com.gfg.dsa.arrays;

public class TrappingRainWater {

    public static void main(String[] args) {
        // int arr[] = new int[] { 3, 0, 1, 2, 5 };
        // int arr[] = new int[] { 5, 4, 3 };
        int arr[] = new int[] { 8, 1, 7, 2, 6, 8 };

        int result = findMaxWaterTrapperNaive(arr);
        System.out.println("Water than be stored is " + result);

    }

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
