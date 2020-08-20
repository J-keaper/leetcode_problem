package cn.keaper.p166;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 */
public class Solution {

    /**
     * 模拟除法
     * 1. 先计算符号位
     * 2. 计算整数部分
     * 3. 计算小数部分，使用Map来存储小数部分每个余数所对应的商在结果中出现的位置
     *              如果遇到已经出现过的余数，那么就会出现循环
     *
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
            return "0";
        }
        if(denominator == 0){
            throw new IllegalArgumentException("denominator is zero");
        }
        // 可能溢出，转换为long
        long numer = Math.abs((long)numerator);
        long denom = Math.abs((long)denominator);

        StringBuilder res = new StringBuilder();
        if((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)){
            res.append("-");
        }
        res.append(numer / denom);
        long mod = numer % denom;
        if(mod == 0){
            return res.toString();
        }

        res.append(".");
        Map<Long, Integer> exist = new HashMap<>();
        while (mod != 0){
            if(exist.containsKey(mod)){
                res.insert(exist.get(mod), "(");
                res.append(")");
                return res.toString();
            }
            exist.put(mod, res.length());
            res.append((mod * 10) / denom);
            mod = (mod * 10) % denom;
        }
        return res.toString();
    }


}
