package com.gfg.dsa.string;

public class PrintFreqOfCharInString {

    public static void main(String[] args) {
        String sample = "geeksforgeeks";
        printFreq(sample);
    }

    private static void printFreq(String sample) {
        int[] count = new int[26];
        for (int i = 0; i < sample.length(); i++) {
            count[sample.charAt(i)-'a']++;
        }
        for (int i = 0; i < count.length ; i++) {
            if(count[i] > 0){
                System.out.println((char)(i + 'a') + " "+ count[i]);
            }
        }
    }
}
