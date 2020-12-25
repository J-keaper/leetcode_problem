package cn.keaper.p95;

import cn.keaper.utils.tree.integer.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class Solution {



    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    /**
     * 递归地获取[l,r]之间的数能够组成的二叉搜索树
     *
     * [l,r]之间的任意一个数都可以作为树的根结点，然后递归地求根结点左边的的数字所能组成的二叉树搜索树 和 根结点右边的数字所能组成的二叉搜索树
     * 然后堆将组合左子树和右子树
     */
    List<TreeNode> generateTrees(int l, int r) {
        List<TreeNode> res = new ArrayList<>();
        if (l > r) {
            res.add(null);
            return res;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> left = generateTrees(l, i - 1);
            List<TreeNode> right = generateTrees(i + 1, r);
            for (TreeNode lNode : left) {
                for (TreeNode rNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lNode;
                    root.right = rNode;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
