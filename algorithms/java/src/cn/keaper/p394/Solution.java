package cn.keaper.p394;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/decode-string/
 */
public class Solution {

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        LinkedList<String> stack_str = new LinkedList<>();
        LinkedList<Integer> stack_num = new LinkedList<>();
        int repeat = 0;
        for (char c : s.toCharArray()) {
            if(c == '['){
                stack_num.push(repeat);
                repeat = 0;
                stack_str.push(res.toString());
                res = new StringBuilder();
            }else if(c == ']'){
                int num = stack_num.pop();
                StringBuilder tmp = new StringBuilder();
                for (int j = 0; j < num; j++) {
                    tmp.append(res.toString());
                }
                res = new StringBuilder(stack_str.pop()).append(tmp);
            }else if (c >= '0' && c <= '9'){
                repeat = repeat * 10 + (c - '0');
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }

}
