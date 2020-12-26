package cn.keaper.review.p104;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;

public class Solution {

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxDepth(TreeBuilder.buildTree(new Integer[]{3,9,20,null,null,15,7})));
    }
}
