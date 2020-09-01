package cn.keaper.p227;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class Solution {


    /**
     * 因为结果中只含有 加减乘除，由因为乘除的优先级大于加减
     * 所以我们可以在遇到乘除时直接计算，遇到加减时先暂存，最后再处理所有加减法
     *
     * 我们使用一个栈来存储加减操作的操作数，对于减法，存进去一个原数的相反数
     * 对于乘除，取出栈顶元素进行计算之后将结果存回栈顶
     * 最后将栈中元素相加
     *
     */
    public int calculate1(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char opt = '+';
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' '){
                continue;
            }
            if(chars[i] >= '0' && chars[i] <= '9'){
                num = num * 10 + (chars[i] - '0');
                continue;
            }
            handleOne(stack, num, opt);
            num = 0;
            opt = chars[i];
        }
        // 处理最后的一组操作
        handleOne(stack, num, opt);

        int res = 0;
        for (Integer one : stack) {
            res += one;
        }
        return res;
    }

    private void handleOne(Stack<Integer> stack, int num, char opt) {
        if (opt == '+') {
            stack.push(num);
        } else if (opt == '-') {
            stack.push(-num);
        } else if (opt == '*') {
            stack.push(stack.pop() * num);
        } else if (opt == '/') {
            stack.push(stack.pop() / num);
        }
    }


    /**
     * 1. 首先去掉空格
     * 2. 将字符串转化为后缀表达式
     * 3. 利用后缀表达式计算值
     */
    public int calculate(String s) {
        StringBuilder trimStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                continue;
            }
            trimStr.append(s.charAt(i));
        }
        List<Object> suffixExp = toSuffix(trimStr.toString());
        return calculate(suffixExp);
    }

    private List<Object> toSuffix(String s){
        List<Object> exp = new ArrayList<>();
        Stack<Character> opt = new Stack<>();
        for (int i = 0; i < s.length();){
            char c = s.charAt(i);
            if(isNumber(c)){
                int num = 0;
                while (i < s.length() && isNumber(s.charAt(i))){
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                exp.add(num);
            }else if(isOperator(c)){
                while (!opt.isEmpty() && !higherPriority(c, opt.peek())){
                    exp.add(opt.pop());
                }
                opt.add(c);
                i++;
            }
        }

        while (!opt.isEmpty()){
            exp.add(opt.pop());
        }
        return exp;
    }


    private int calculate(List<Object> suffixExp){
        Stack<Integer> num = new Stack<>();
        for (Object o : suffixExp) {
            if(o instanceof Integer){
                num.push((Integer) o);
            }else {
                int second = num.pop(), first = num.pop();
                num.push(calculate(first, (Character) o, second));
            }
        }
        return num.pop();
    }
    private boolean isNumber(char c){
        return c >= '0' && c <= '9';
    }


    private boolean isOperator(char c){
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean higherPriority(char a, char b){
        return (a == '*' || a == '/') && (b == '+' || b == '-');
    }


    private int calculate(int a, char opt, int b){
        switch (opt){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
        }
        throw new IllegalArgumentException();
    }
}
