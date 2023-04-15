package com.gfg.dsa.stack;

import java.util.Stack;

public class LargestRectangularAreaInHistogram {
    public static void main(String[] args) {

        System.out.println(getMaxArea(new int[]{6, 2, 5, 4, 5, 6}));
        System.out.println("using better solution");
        System.out.println(getMaxAreaBetterSolution(new int[]{6, 2, 5, 4, 5, 6}));
        System.out.println("using best solution");
        System.out.println(getMaxAreaBestSolution(new int[]{6, 2, 5, 4, 5, 6}));
    }

    //Time complexity O(n2)
    //naive solution
    public static int getMaxArea(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            for (int j = i - 1; j >= 0; j--) {//loop from current element to the left side of the array
                if (arr[j] >= arr[i]) {//if the element is greater than current index element, that means we can extend to the left so then add value of current index to the curr sum
                    curr = curr + arr[i];
                } else {//if the element is smaller than current , then come out of the loop as we cannot get max area
                    break;
                }
            }
            for (int k = i + 1; k < arr.length; k++) {//loop from current element to the right side of the array
                if (arr[k] >= arr[i]) {//if the element is greater than current index element, that means we can extend to the right so then add value of current index to the curr sum
                    curr = curr + arr[i];
                } else {
                    break;
                }
            }
            result = Math.max(curr, result);
        }
        return result;

    }

    //better solution

    /**
     * Initialize result =0
     * Find Previous smaller element for every element
     * Find Next smaller element for every element
     * Then do the following
     *  curr = arr[i]
     *  curr = curr + (i - previousSmall[i] - 1) * arr[i]
     *  curr = curr + (nextSmall[i] - i - 1) * arr[i]
     *  result = max(result, curr)
     *
     */

    public static int getMaxAreaBetterSolution(int[] arr) {
        int result =0;
        int[] previousSmall = new int[arr.length];
        int[] nextSmall = new int[arr.length];
        Stack<Integer> s = new Stack<>();


        //First fill the previousSmall array
        s.push(0);
        for (int i = 0; i < arr.length; i++) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){//if current element is lesser than top of stack, then pop the stack element
                s.pop();
            }
            //we found the previous small element or we have an empty stack
            int previousSmallValue = s.isEmpty() ? -1:s.peek();
            previousSmall[i]=previousSmallValue;
            s.push(i);
        }

        //we are done with the stack, pop everything out
        while(!s.isEmpty()){
            s.pop();
        }


        //Now fill the nextSmall array by looping in reverse order
        s.push(arr.length-1);
        for (int i = arr.length-1; i > 0; i--) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){//if current element is lesser than top of stack, then pop the stack element
                s.pop();
            }
            //we found the previous small element or we have an empty stack
            int nextSmallValue = s.isEmpty() ? arr.length:s.peek();
            nextSmall[i]=nextSmallValue;
            s.push(i);
        }

        //now we have the arrays filled
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            curr = curr + (i-previousSmall[i]-1) * arr[i];
            curr = curr + (nextSmall[i]-i-1) * arr[i];
            result = Math.max(result, curr);
        }

        return result;
    }


    //Best Solution

    public static int getMaxAreaBestSolution(int[] arr){
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int result = 0;
        int topOfStack = 0;
        int curr;
        for (int i = 0; i < n; i++) {
            //while the stack is not empty
            // and while you dont find an item lesser than current element, pop out the stack and process the popped item
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                topOfStack = s.peek();//now we will calculate the area considering this popped item as the main item and looking for left nearest lowest and right nearest loweest
                //we know that the item below this one in stack is the nearest lowest for the popped item and the item in the iteration is the right nearest lowest
                //unless if the stack is empty - then
                s.pop();//before poping make sure to save that element in a variable - as that is element
                curr = arr[topOfStack] * ( s.isEmpty() ? i :(i - s.peek() -1)); //we know we are processing the index topOfStack so arr[topOfStack] must be multipied with number of times ( right lowest index - left lowest index)
                result = Math.max(result, curr);
            }
            s.push(i);
        }
        //we are processing the array
        //but we have to processing the remaining elements in the stack
        while (!s.isEmpty()){
            topOfStack = s.peek();
            s.pop();
            curr = arr[topOfStack] * ( s.isEmpty() ? n :(n - s.peek() - 1));
            result = Math.max(result, curr);
        }
        return result;

    }





}
