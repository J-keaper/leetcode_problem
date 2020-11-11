package cn.keaper.p514;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/freedom-trail/
 */
public class Solution {


    /**
     * 动态规划
     * 定义 ring 的长度为n，key的长度为m
     * 定义 dp[i][j] 表示从前往后拼写出 key 的第 i 个字符，ring 的第 j 个字符与 12:00 方向对齐的最少步数
     *
     *
     * 状态转移过程为 dp[i][j] = min(dp[i-1][k] + min(|j-k|, n-|j-k|)), 其中k满足 ring[k] == key[i-1], ring[j] == key[i]
     *
     * 优化：提前存储key中每个字符在ring中的位置
     *
     */
    public int findRotateSteps2(String ring, String key) {
        int n = ring.length(), m = key.length();
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            pos[ring.charAt(i) - 'a'].add(i);
        }

        int[][] dp = new int[m][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        for (int i : pos[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i , n - i) + 1;
        }

        for(int i = 1; i < m ; i ++){
            for (int k : pos[key.charAt(i - 1) - 'a']) {
                for (int j : pos[key.charAt(i) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[m - 1][i]);
        }
        return res;

    }



    /**
     * DFS + 记忆化
     * 优化：提前存储key中每个字符在ring中的位置
     */
    public int findRotateSteps1(String ring, String key) {
        Integer[] mem = new Integer[10101];
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }
        for (int i = 0; i < ring.length(); i++) {
            pos[ring.charAt(i) - 'a'].add(i);
        }
        return dfs(pos, mem, ring, key, 0, 0);
    }


    int dfs(List<Integer>[] pos, Integer[] mem, String ring, String key, int ringPos, int keyPos) {
        if (keyPos == key.length()) {
            return 0;
        }
        if (mem[ringPos * 100 + keyPos] != null) {
            return mem[ringPos * 100 + keyPos];
        }
        int minDis = Integer.MAX_VALUE;
        char kc = key.charAt(keyPos);
        for (Integer i : pos[kc - 'a']) {
            int dis = Math.min((i - ringPos + ring.length()) % ring.length(), (ringPos - i + ring.length()) % ring.length()) + 1;
            int subStep = dis + dfs(pos, mem, ring, key, i, keyPos + 1);
            minDis = Math.min(subStep, minDis);
        }
        return mem[ringPos * 100 + keyPos] = minDis;
    }

    /**
     * DFS + 记忆化
     */
    public int findRotateSteps(String ring, String key) {
        Integer[] mem = new Integer[10101];
        return dfs(mem, ring, key, 0, 0);
    }


    int dfs(Integer[] mem, String ring, String key, int ringPos, int keyPos) {
        if (keyPos == key.length()) {
            return 0;
        }
        if (mem[ringPos * 100 + keyPos] != null) {
            return mem[ringPos * 100 + keyPos];
        }
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) == key.charAt(keyPos)) {
                int dis = Math.min((i - ringPos + ring.length()) % ring.length(), (ringPos - i + ring.length()) % ring.length()) + 1;
                int subStep = dis + dfs(mem, ring, key, i, keyPos + 1);
                minDis = Math.min(subStep, minDis);
            }
        }
        return mem[ringPos * 100 + keyPos] = minDis;
    }

}
