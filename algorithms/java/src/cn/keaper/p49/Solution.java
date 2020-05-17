package cn.keaper.p49;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/
 */
public class Solution {

    /**
     * 不同的异位词 排序后都是相同的，以排序后的字符串作为key将异位词组织在一起
     * 最后输出所有分组
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if(!group.containsKey(sortedStr)){
                group.put(sortedStr, new ArrayList<>());
            }
            group.get(sortedStr).add(str);
        }
        return new ArrayList<>(group.values());
    }

}
