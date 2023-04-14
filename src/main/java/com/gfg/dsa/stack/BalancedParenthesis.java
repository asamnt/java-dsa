package com.gfg.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParenthesis {

    public static void main(String[] args) {
        Boolean result = isBalanced("[{()}");
        System.out.println("The string is :"+result);
    }

    public static Boolean matching(Character a , Character b){
        return(
                (a=='(' && b==')') ||
                (a=='{' && b=='}') ||
                (a=='[' && b==']')
                );
    }

    //Time and space complexity : O(n)
    public static Boolean isBalanced(String str){

        Deque<Character> s = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if(x=='(' || x=='[' || x=='{')//if any opening bracket push to the stack
                s.push(x);
            else{//match with top of the stack
                if(s.isEmpty()) return false;//if stack is empty then it means there is no matching bracket - so return false
                else if(!matching(s.peek(),x)) return false;//if stack is not empty check if matching with top item from stack
                else s.pop();//else matching which means pop it out so that you can compare the next element in the queue
            }
        }
        return (s.isEmpty());//if after processing the passed string, the stack still has elements then bracket don't match, so we return false
    }
}
