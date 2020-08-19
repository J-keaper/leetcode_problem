package cn.keaper.p139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/
 */
public class Solution {

    /**
     * DFS + 记忆化
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] store = new Boolean[s.length()];
        return wordBreak(s, 0, wordDict, store);
    }

    private boolean wordBreak(String s, int start, List<String> wordDict, Boolean[] store) {
        if(start == s.length()){
            return true;
        }
        if(store[start] != null){
            return store[start];
        }
        for (String word : wordDict) {
            if(s.startsWith(word, start) && wordBreak(s, start + word.length(), wordDict, store)){
                return store[start] = true;
            }
        }
        return store[start] = false;
    }



    /**
     * dp[i]表示s[0,i)是否能够拆分为字典中的单词
     * 初始化dp[0] = true
     * 状态转移方程为 对于[0,i)范围的任一j,如果dp[j] && wordDict.contains(s[j,i-1)),那么dp[i] = true
     *
     * maxLength 表示单词字典中的最大单词长度，用来优化状态转移过程
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        int maxLength = 0;
        for (String word : wordDict) {
            maxLength = Integer.max(maxLength, word.length());
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i ++){
            for (int j = i - 1; j >=0 && i - j <= maxLength; j--) {
                if(dp[j] && wordDictSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }



}
