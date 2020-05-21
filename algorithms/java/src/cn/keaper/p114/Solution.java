package cn.keaper.p114;

import cn.keaper.utils.tree.integer.TreeNode;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class Solution {


    /**
     * 1. 将原来的右子树接到左子树的最右边节点
     * 2. 将左子树插入到右子树的地方
     * 3. 考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
     */
    public void flatten(TreeNode root) {
        while (root != null){
            TreeNode rightInRight = root.left;
            if(rightInRight != null){  // 左子树不为null
                while (rightInRight.right != null){  // 找到左子树的最右节点
                    rightInRight = rightInRight.right;
                }
                rightInRight.right = root.right;  // 将当前节点的右子树挂到左子树的最右节点上
                root.right = root.left;     // 将左子树挂到右子树上
                root.left = null;   // 左子树置空
            }
            root = root.right;  // 下一个节点
        }
    }


}
