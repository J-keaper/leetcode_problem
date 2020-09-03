package cn.keaper.p230;

import cn.keaper.utils.tree.integer.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class Solution {


    /**
     * 中序遍历，取中序遍历的第k个元素
     * 优化：因为只需要第K个元素，所以在中序遍历的时候可以到第K个元素就停止
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inOrder = new ArrayList<>();
        inOrder(root, inOrder, k);
        return inOrder.get(k - 1);
    }

    private void inOrder(TreeNode root, List<Integer> inOrder, int k){
        if(inOrder.size() >= k){
            return;
        }
        if(root.left != null){
            inOrder(root.left, inOrder, k);
        }
        inOrder.add(root.val);
        if(root.right != null){
            inOrder(root.right, inOrder, k);
        }
    }




}
