package cn.keaper.review.p114;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;
import cn.keaper.utils.tree.integer.TreePrinter;

public class Solution {

    public void flatten(TreeNode root) {
        while (root != null){
            TreeNode node = root.left;
            if(node == null){
                root = root.right;
                continue;
            }

            while (node.right != null){
                node = node.right;
            }
            node.right = root.right;
            root.right = root.left;
            root.left = null;
            root = root.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildTree(new Integer[]{1,2,5,3,4,null,6});
        new Solution().flatten(root);
        TreePrinter.printTree(root);
    }
}
