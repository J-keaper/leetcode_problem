package cn.keaper.p1207;

/**
 * https://leetcode.com/problems/unique-number-of-occurrences/
 */
public class Solution {

    /**
     * 两次计数排序（Counting sort）
     */
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        for (int i : arr) {
            count[i + 1000] ++;
        }

        int[] countCount = new int[2002];
        for (int i : count) {
            if(i > 0){
                countCount[i] ++;
            }
        }

        for (int i : countCount) {
            if(i > 1){
                return false;
            }
        }
        return true;
    }

}
