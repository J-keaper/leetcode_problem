package cn.keaper.review.p111;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;

public class Solution {

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left == null){
            return minDepth(root.right) + 1;
        }
        if(root.right == null){
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().minDepth(TreeBuilder.buildTree(new Integer[]{3,9,20,null,null,15,7})));
        System.out.println(new Solution().minDepth(TreeBuilder.buildTree(new Integer[]{2,null,3,null,4,null,5,null,6})));
    }
}
