package cn.keaper.p104;

import cn.keaper.tree.integer.TreeBuilder;
import cn.keaper.tree.integer.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
class Solution {

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + Integer.max(maxDepth(root.left),maxDepth(root.right));
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxDepth(TreeBuilder.buildTree(new Integer[]{})));
        System.out.println(solution.maxDepth(TreeBuilder.buildTree(new Integer[]{1})));
        System.out.println(solution.maxDepth(TreeBuilder.buildTree(new Integer[]{1,2})));
        System.out.println(solution.maxDepth(TreeBuilder.buildTree(new Integer[]{3,9,20,null,null,15,7})));
        System.out.println(solution.maxDepth(TreeBuilder.buildTree(new Integer[]{3,9,20,null,null,15,7,1})));
    }

}