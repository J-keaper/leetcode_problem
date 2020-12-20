package cn.keaper.review.p20;

import java.util.LinkedList;

public class Solution {

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else if(stack.isEmpty()){
                return false;
            }else if(!stack.peek().equals(map(c))){
                return false;
            }else {
                stack.pop();
            }
        }
        return stack.isEmpty();
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
        System.out.println(new Solution().isValid("()"));
        System.out.println(new Solution().isValid("()[]{}"));
        System.out.println(new Solution().isValid("(]"));
        System.out.println(new Solution().isValid("([)]"));
        System.out.println(new Solution().isValid("{[]}"));
    }
}