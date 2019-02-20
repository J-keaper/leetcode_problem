package cn.keaper.p20;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i ++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else if(stack.empty()){
                return false;
            }else if(map(c) == stack.peek()){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.empty();
    }


    /**
     * 手动模拟栈操作,效率更高
     */
    public boolean isValid2(String s) {
        char [] stack = new char[s.length()];
        int top = -1;
        for(int i = 0 ; i < s.length() ; i ++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack[++ top] = c;
            }else if(top == -1){
                return false;
            }else if(map(c) == stack[top]){
                top --;
            }else{
                return false;
            }
        }
        return top == -1;
    }
    private char map(char c){
        switch (c){
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                return ' ';
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] testList = new String[]{"()","()[]{}","(]","([)]","]}","[[[[[]]]]]()[]{}{{[()]}}","(])"};
        Arrays.stream(testList).forEach(o -> {
            System.out.println(o + "\t\t" + solution.isValid(o));
        });
    }

}