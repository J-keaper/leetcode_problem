package cn.keaper.p111;

import cn.keaper.tree.integer.TreeBuilder;
import cn.keaper.tree.integer.TreeNode;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class Solution {

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left != null && root.right != null){
            return 1 + Integer.min(minDepth(root.left),minDepth(root.right));
        }
        if(root.left == null){
            return 1 + minDepth(root.right);
        }
        return 1 + minDepth(root.left);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDepth(TreeBuilder.buildTree(new Integer[]{3,9,20,null,null,15,7})));
        System.out.println(solution.minDepth(TreeBuilder.buildTree(new Integer[]{3,9})));
        System.out.println(solution.minDepth(TreeBuilder.buildTree(new Integer[]{3})));
        System.out.println(solution.minDepth(TreeBuilder.buildTree(new Integer[]{})));
    }
}
