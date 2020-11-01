package cn.keaper.p140;


import java.util.*;

/**
 * https://leetcode.com/problems/word-break-ii/
 */
public class Solution {


    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> store = new HashMap<>();
        List<List<String>> wordsList = dfs(store, wordDict, s, 0);

        List<String> res = new ArrayList<>();
        for (List<String> words : wordsList) {
            res.add(String.join(" ", words.toArray(new String[]{})));
        }
        return res;
    }

    /**
     *
     * @param store 记忆化存储 以某个位置开始的子串的 拆分组合
     * @param wordDict 单词字典
     * @param s 原字符串
     * @param start 开始位置
     * @return 从start开始字符串的 拆分组合
     */
    private List<List<String>> dfs(Map<Integer, List<List<String>>> store, List<String> wordDict,
                     String s, int start){
        if(start == s.length()){
            return Collections.singletonList(new ArrayList<>());
        }
        if(store.containsKey(start)){
            return store.get(start);
        }
        List<List<String>> partSolution = new ArrayList<>();
        for (String word : wordDict) {
            if(s.startsWith(word, start)){
                List<List<String>> rightSolution = dfs(store, wordDict, s, start + word.length());
                for (List<String> solution : rightSolution) {
                    partSolution.add(add(word, solution));
                }
            }
        }
        store.put(start, partSolution);
        return partSolution;
    }

    private List<String> add(String word, List<String> right){
        List<String> res = new LinkedList<>();
        res.add(word);
        res.addAll(right);
        return res;
    }

}
