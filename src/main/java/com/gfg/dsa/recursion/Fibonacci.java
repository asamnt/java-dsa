package com.gfg.dsa.recursion;

public class Fibonacci {

    //time : O(2^n) space : O(n)
    public static int getNthFib(int n){
        if(n==2){
            return 1;
        } else if (n == 1){
            return 0;
        } else{
            return getNthFib(n-1) + getNthFib(n-2);
        }
    }

    //time : O(n) space : O(1)
    public static int getNthFibTabulation(int n){
        int[] lastTwo = {0,1};
        int counter = 3;
        while (counter <= n){
            int nextFib = lastTwo[0] + lastTwo[1];
            lastTwo[0] = lastTwo[1];
            lastTwo[1] = nextFib;
            counter++;
        }
        return n > 1 ? lastTwo[1] : lastTwo[0];
    }

    public static void main(String[] args) {
        int nthFib = getNthFib(8);
        System.out.println(nthFib);

        nthFib = getNthFibTabulation(9);
        System.out.println(nthFib);
    }
}
