package cn.keaper.p402;

import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-k-digits/
 */
public class Solution {

    /**
     * 使用数组实现一个栈，效率更高
     */
    public String removeKdigits1(String num, int k) {
        char[] stack = new char[num.length()];
        int size = 0;
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && size > 0 && stack[size - 1] > num.charAt(i)){
                size --;
                k--;
            }
            stack[size++] = num.charAt(i);
        }

        while (k-- > 0){
            size --;
        }

        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < size && stack[i] == '0') {
            i++;
        }
        while (i < size){
            res.append(stack[i++]);
        }
        return res.length() == 0 ? "0" : res.toString();
    }


    /**
     * 维护一个单调非递减的单调栈
     * 依次将数字加入栈中，对于每一个元素我们可以选择是否删除
     * 如果当前数字小于栈顶元素，那么删除栈顶元素可以得到更小的数，应该删除
     * 否则的话加入栈中
     *
     * 注意最多只能删除K次
     *
     * 如果最后长度大于 n-k，显然删除最后的数字可以得到更小的数
     *
     */
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.add(num.charAt(i));
        }

        while (k-- > 0){
            stack.pop();
        }

        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < stack.size() && stack.get(i) == '0') {
            i++;
        }
        while (i < stack.size()){
            res.append(stack.get(i++));
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}
