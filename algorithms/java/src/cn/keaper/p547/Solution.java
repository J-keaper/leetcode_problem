package cn.keaper.p547;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/friend-circles/
 */
public class Solution {

    private int[] parent;


    /**
     * 并查集
     */
    public int findCircleNum(int[][] M) {
        int N = M.length;
        parent = new int[N];
        Arrays.fill(parent, -1);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if(M[i][j] == 1){
                    union(i,j);
                }
            }
        }
        int count = 0;
        for (int value : parent) {
            if (value == -1) {
                count++;
            }
        }
        return count;
    }


    /**
     * 找到i的祖先
     */
    private int find(int i){
        if(parent[i] == -1){
            return i;
        }
        // 路径压缩，顺便将每个元素连接到其祖先上
        return parent[i] = find(parent[i]);
    }

    /**
     * 合并i,j所在的集
     */
    private void union(int i, int j){
        int pi = find(i);
        int pj = find(j);
        if(pi != pj){
            parent[pi] = pj;
        }
    }

}
