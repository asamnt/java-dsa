package com.gfg.dsa.recursion;

public class PalindromeCheck {

    static boolean isPalindrome(String str, int start, int end){
        if(start >= end) return true;
        //what is happening here?
        //we check if the first and the last char are same
        //and then we recursively check if the string excluding the first and last char is palindrome or not
        return str.charAt(start) == str.charAt(end) && isPalindrome(str, start + 1, end -1);
    }

    public static void main(String[] args) {
        String str = "aabaag";
        int start = 0;
        int end = str.length()-1;
        boolean check = isPalindrome(str, start, end);
        System.out.println("is the string palindrome: "+ check);

    }
}
