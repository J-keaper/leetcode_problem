package cn.keaper.p96;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 */
public class Solution {

    /**
     * 1～n能够组成的二叉搜索数可以分为n中情况，也就是1～n分别作为根结点，左边的树作为左子树的节点，右边的树作为右子树的节点
     * 对于每个数最为根结点的情况，形成的二叉搜索树个数为 将左子树能够形成的二叉树搜索树个数 和 右子树形成的二叉搜索树个数 相乘
     * 例如：
     * f(3) = f(0) * f(2) + f(1) * f(1) + f(2) * f(0)
     *
     * 递归处理，会造成重复计算，效率低
     */
    public int numTrees(int n) {
        if(n <= 1){
            return 1;
        }
        int num = 0;
        for (int i = 0; i < n; i++) {
            num += numTrees(i) * numTrees(n - i - 1);
        }
        return num;
    }

    /**
     * 动态规划，将结果保存，避免重复计算
     */
    public int numTrees1(int n) {
        int[] num = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if(i <= 1){
                num[i] = 1;
                continue;
            }
            for (int j = 0; j < i; j++) {
                num[i] += num[j] * num[i - j - 1];
            }
        }
        return num[n];
    }
}
