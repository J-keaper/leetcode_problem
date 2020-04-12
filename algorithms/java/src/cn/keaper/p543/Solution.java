package cn.keaper.p543;

import cn.keaper.utils.tree.integer.TreeNode;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class Solution {

    private int res;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        depth(root);
        return res - 1;
    }


    /**
     * 假设我们知道对于该节点的左儿子向下遍历经过最多的节点数 L （即以左儿子为根的子树的深度）
     * 和其右儿子向下遍历经过最多的节点数 R （即以右儿子为根的子树的深度）
     * 那么以该节点为界的路径经过节点数的最大值即为 L+R+1。
     *
     * 遍历求深度，同时记录以每个节点为界的最长路径（路径上的节点数 - 1）
     *
     */
    private int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        res = Integer.max(res, l + r + 1);
        return 1 + Integer.max(l,r);
    }

}
