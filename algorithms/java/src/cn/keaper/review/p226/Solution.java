package cn.keaper.review.p226;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;
import cn.keaper.utils.tree.integer.TreePrinter;

public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

    public static void main(String[] args) {
        TreePrinter.printTree(new Solution().invertTree(TreeBuilder.buildTree(new Integer[]{4,2,7,1,3,6,9})));
    }

}
