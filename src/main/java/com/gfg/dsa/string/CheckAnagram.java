package com.gfg.dsa.string;

public class CheckAnagram {
    public static void main(String[] args) {
        String s1 = "bbaacb";
        String s2 = "aabbbc";
        System.out.println(checkAnagram(s1,s2));
    }

    private static boolean checkAnagram(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        int count[] = new int[256];//array to store how many times a char is present
        for (int i = 0; i < s1.length() ; i++) {//traversing through length of string
            count[s1.charAt(i)]++;//for string s1, we are incrementing the count of the char by 1
            count[s2.charAt(i)]--;//for string s2, we are decrementing the count of the char by 1
        }
        //at the end if the count of all char in the count array is 0, it means there is a match of chars
        //if positive then it means there is a char in s1 more number of times than s2
        //if negative then it means there is a char in s2 more number of times than s1
        for (int i=0; i< count.length; i++){
            if(count[i] != 0) return false;
        }

        return true;
    }
}
