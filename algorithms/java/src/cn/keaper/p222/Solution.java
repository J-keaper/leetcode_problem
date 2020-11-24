package cn.keaper.p222;

import cn.keaper.utils.tree.integer.TreeNode;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class Solution {


    public int countNodes(TreeNode root) {
        return root == null ? 0 : 1 + countNodes(root.left) + countNodes(root.right);
    }
}
