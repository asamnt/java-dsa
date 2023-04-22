package com.gfg.dsa.string;

public class PalindromeCheck {

    public static void main(String[] args) {
        String str = "abaccaba";
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String str){
        int begin = 0;
        int end = str.length()-1;
        while(end > begin){
            if(str.charAt(begin) != str.charAt(end)){
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}
