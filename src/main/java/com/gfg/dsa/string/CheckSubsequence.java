package com.gfg.dsa.string;

public class CheckSubsequence {

    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "grgeeeee";
        System.out.println(checkSubsequence(s1,s2, s1.length(), s2.length()));
    }

    private static boolean checkSubsequence(String s1, String s2, int m, int n) {
        if(n==0) return true;//this means we have reached end of the sequence string and hence it is a valid subsequence
        if(m==0) return false;//this means we have finished parsing the main string and have not found a subsequence

        if(s1.charAt(m-1) == s2.charAt(n-1)){//if the char are same, then recursive call - decrement both index
            return checkSubsequence(s1,s2,m-1,n-1);
        } else{//recursive call - but decrement only the index of the main string to check for next char
            return checkSubsequence(s1, s2, m-1, n);
        }

    }
}
