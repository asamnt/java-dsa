package com.gfg.dsa.stack;

import java.util.Stack;

public class LargestRectangleWithAllOnes {

    public static void main(String[] args) {
        int result = getLargestRectangle(new int[][]{
                new int[] {1,0,0,1,1},
                new int[] {0,0,0,1,1},
                new int[] {1,1,1,1,1},
                new int[] {0,1,1,1,1}
        });
        System.out.println(result);
    }

    public static int getLargestRectangle(int[][] arr){
        int result =0;

        result = getMaxAreaBestSolution(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length ; j++) {
                if(arr[i][j]==1){//only if current value is 1
                    arr[i][j] = arr[i][j] + arr[i-1][j];//add the previous row value to current row value
                }
            }
            result = Math.max(result, getMaxAreaBestSolution(arr[i]));
        }
        return result;
    }

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
