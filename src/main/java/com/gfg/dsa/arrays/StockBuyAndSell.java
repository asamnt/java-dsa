package com.gfg.dsa.arrays;

public class StockBuyAndSell {

    public static void main(String[] args) {
        int arr[] = new int[] { 5, 1, 22, 25, 6, -1, 8, 10 };

        int profit = findMaxProfit(arr);
        System.out.println(profit);
    }

    private static int findMaxProfit(int[] arr) {
        int profit = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                profit += arr[i] - arr[i - 1];
                // cumulative - add the diff between values ar two indices if curr index
                // value greater than prev index value, else skip
            }
        }
        return profit;
    }
}
