package cn.keaper.p392;

import java.util.*;

/**
 * https://leetcode.com/problems/is-subsequence/
 */
public class Solution {

    /**
     * N - the length of s, M - the length of t
     * Time : O(N) + O(M)
     */
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            index = t.indexOf(s.charAt(i),index + 1);
            if(index == -1){
                return false;
            }
        }
        return true;
    }


    /**
     * This is Solution for Follow up:
     * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B,
     * and you want to check one by one to see if T has its subsequence.
     * In this scenario, how would you change your code?
     *
     *
     * Detail:
     * Record the indexes for each character in t.
     * if s[i] matches t[j], then s[i+1] should match a character in t with index bigger than j.
     * This can be reduced to find the first element larger than a value in an sorted array (find upper bound),
     * which can be achieved using binary search.
     *
     * This Solution if faster when there are lots of incoming S,
     * because string t only need to be handle one time and binary search is fast.
     *
     *
     */
    public boolean isSubsequence1(String s, String t) {
        Map<Character,List<Integer>> idx = new HashMap<>(26);
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            idx.computeIfAbsent(c, k -> new ArrayList<>());
            idx.get(c).add(i);
        }
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(idx.get(c) == null) {
                return false;
            }
            int p = Collections.binarySearch(idx.get(c),pos);
            if(p < 0) {
                p = - p - 1;
            }
            if(p == idx.get(c).size()){
                return false;
            }
            pos = idx.get(c).get(p) + 1;
        }
        return true;
    }
}
