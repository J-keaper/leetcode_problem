package cn.keaper.p842;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/split-array-into-fibonacci-sequence/
 */
public class Solution {

    /**
     * DFS + 剪枝
     */
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        dfs(S, 0, res);
        return res;
    }

    public boolean dfs(String s, int start, List<Integer> res){
        if(start == s.length()){
            return res.size() >= 3;
        }
        long num = 0; // 防止溢出
        for (int i = start; i < s.length(); i++) {
            if(i > start && s.charAt(start) == '0'){ // 如果第一位为0，后面不能有别的数
                break;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if(num > Integer.MAX_VALUE){ // 溢出会导致下面的比较判断错误
                break;
            }
            if(res.size() >= 2){
                long prev2 = res.get(res.size() - 2), prev1 = res.get(res.size() - 1);
                if(num > prev1 + prev2){
                    break;
                }else if(num < prev1 + prev2){
                    continue;
                }
            }
            res.add((int) num);
            if(dfs(s, i + 1, res)){
                return true;
            }else {
                res.remove(res.size() - 1);
            }
        }
        return false;
    }






}
