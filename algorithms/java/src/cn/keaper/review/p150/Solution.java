package cn.keaper.review.p150;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if(token.length() == 1 && "+-*/".contains(token)){
                int a = stack.pop(), b = stack.pop();
                switch (token){
                    case "+": stack.push(b + a); break;
                    case "-": stack.push(b - a); break;
                    case "*": stack.push(b * a); break;
                    case "/": stack.push(b / a); break;
                }
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(new Solution().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(new Solution().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
