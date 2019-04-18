package cn.keaper.p112;

import cn.keaper.tree.integer.TreeBuilder;
import cn.keaper.tree.integer.TreeNode;

/**
 * https://leetcode.com/problems/path-sum/
 */
public class Solution {

    /**
     * 通常递归中需要判断叶子节点时，左右子树不能同等对待，因为子树为null时不是叶子节点
     */


    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return sum == root.val;
        }
        int diff = sum - root.val;
        if(root.left != null && root.right != null){
            return hasPathSum(root.left,diff) || hasPathSum(root.right,diff);
        }
        if(root.left == null){
            return hasPathSum(root.right,diff);
        }
        return hasPathSum(root.left,diff);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{}),0));
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{2}),2));
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{2,3}),5));
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{2,3}),4));
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{2,2,3}),4));
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{2,2,3}),5));
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{2,2,3}),6));
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{2,2,3,4}),4));
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{2,2,3,4}),8));
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1}),26));
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1}),17));
        System.out.println(solution.hasPathSum(TreeBuilder.buildTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1}),18));


    }
}
