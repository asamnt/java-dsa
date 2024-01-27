package com.gfg.dsa.arrays.easy;

public class LeadersInArray {

    public static void main(String[] args) {
        int arr[] = new int[10], n = 10;
        arr[0] = 5;
        arr[1] = 8;
        arr[2] = 24;
        arr[3] = 23;
        arr[4] = -8;
        arr[5] = 12;
        // System.out.println("Before fin");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }

        printLeadersInArray(arr);
    }

    public static void printLeadersInArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            boolean isAnybodyGreater = false;
            for (int j = i + 1; j < arr.length; j++) {// we compare each element with all the elements in the array
                if (arr[i] <= arr[j]) {
                    // if the next element is greater than current element being compared then the
                    // current element is not a leader
                    isAnybodyGreater = true;
                    isAnybodyGreater = true;
                    // so set flag isAnybodyGreater to true
                    isAnybodyGreater = true;
                    break;
                }
            }
            if (isAnybodyGreater == false) {
                System.out.println(arr[i]);
            }

        }
    }

    // this will print leaders in reverse order
    public static void printLeadersInArrayEfficient(int[] arr) {
        int currLeader = arr[arr.length - 1];// set current leader as last element in the array
        System.out.println(currLeader);
        for (int i = arr.length - 2; i > 0; i--) {
            if (currLeader < arr[i]) { // this means curr leader(the item to the right) is less than current i
                                       // element(item to the left)
                currLeader = arr[i];// set curr leader as i element
                System.out.println(currLeader);
            }
        }

    }
}
