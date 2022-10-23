package com.gfg.dsa.recursion;

public class PrintNto1Recur {

    public static void main(String[] args) {

        int n = 4;
        System.out.println("print n to 1");
        printNto1func(n);
        System.out.println("print 1 to n");
        print1toNfunc(n);

    }
    //time theeta(n)
    //space n+1
    static void printNto1func(int n){
        if (n==0) return;
        System.out.print(n + "");
        printNto1func(n-1);

    }

    static void print1toNfunc(int n){
        if (n==0) return;
        printNto1func(n-1);
        System.out.print(n + "");


    }

}
