package cn.keaper.review.p112;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;

public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return sum == root.val;
        }
        if(root.right == null){
            root.left.val += root.val;
            return hasPathSum(root.left, sum);
        }
        if(root.left == null){
            root.right.val += root.val;
            return hasPathSum(root.right, sum);
        }
        root.left.val += root.val;
        root.right.val += root.val;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().hasPathSum(TreeBuilder.buildTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1}), 22));
    }
}
