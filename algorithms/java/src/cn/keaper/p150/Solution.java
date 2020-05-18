package cn.keaper.p150;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class Solution {

    /**
     * 后缀表达式求值(http://en.wikipedia.org/wiki/Reverse_Polish_notation)
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if(!isOperation(token)){
                stack.push(Integer.parseInt(token));
                continue;
            }
            int b = stack.pop(), a = stack.pop();
            switch (token){
                case "+" : a += b; break;
                case "-" : a -= b; break;
                case "*" : a *= b; break;
                case "/" : a /= b; break;
            }
            stack.push(a);
        }
        return stack.pop();
    }

    private boolean isOperation(String token){
        return token.length() == 1 && "+-*/".contains(token);
    }


}
