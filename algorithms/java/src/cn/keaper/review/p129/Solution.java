package cn.keaper.review.p129;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;

public class Solution {

    private int sum = 0;


    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        sum = 0;
        dfs(root);
        return sum;
    }



    public void dfs(TreeNode root) {
        if(root.left == null && root.right == null){
            sum += root.val;
            return;
        }
        if(root.left != null){
            root.left.val += root.val * 10;
            dfs(root.left);
        }
        if(root.right != null){
            root.right.val += root.val * 10;
            dfs(root.right);
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().sumNumbers(TreeBuilder.buildTree(new Integer[]{1,2,3})));
        System.out.println(new Solution().sumNumbers(TreeBuilder.buildTree(new Integer[]{4,9,0,5,1})));
    }
}
