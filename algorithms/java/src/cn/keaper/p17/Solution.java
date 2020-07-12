package cn.keaper.p17;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class Solution {

    private static String[] chars = new String[]
            {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private List<String> res;


    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        dfs("", digits);
        return res;
    }

    private void dfs(String part, String digits){
        if(digits.length() == 0){
            if(part.length() > 0){
                res.add(part);
            }
            return;
        }
        char[] alphas = chars[digits.charAt(0) - '0'].toCharArray();
        for (char alpha : alphas) {
            dfs(part + alpha, digits.substring(1));
        }
    }

}
