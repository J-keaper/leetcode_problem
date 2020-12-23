package cn.keaper.p99;

import cn.keaper.utils.tree.integer.TreeNode;

import java.util.*;


/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 */
public class Solution {


    /**
     * 首先得到中序遍历的序列，从中序遍历中找到逆序的两个节点，交换两个节点的val
     */
    public void recoverTree(TreeNode root) {
        // 1. 中序遍历
        List<TreeNode> inOrder = inOrder(root);
        // 2. 找到被交换的两个节点
        TreeNode x = null, y = null;
        for (int i = 1; i < inOrder.size(); i++) {
            if (inOrder.get(i).val < inOrder.get(i - 1).val) {
                x = inOrder.get(i - 1);
                break;
            }
        }
        for (int i = inOrder.size() - 1; i > 0; i--) {
            if (inOrder.get(i).val < inOrder.get(i - 1).val) {
                y = inOrder.get(i);
                break;
            }
        }

        // 3. 交换两个节点的val
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }

    List<TreeNode> inOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> res = new ArrayList<>();
        res.addAll(inOrder(root.left));
        res.add(root);
        res.addAll(inOrder(root.right));
        return res;
    }


    /**
     * 使用栈进行迭代中序遍历时同时记录两个节点
     */
    public void recoverTree1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        TreeNode x = null, y = null;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode poll = stack.poll();
            if(prev != null && poll.val < prev.val){
                y = poll;
                if(x == null){
                    x = prev;
                }else{
                    break;
                }
            }
            prev = poll;
            root = poll.right;
        }

        // 交换两个节点的val
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;

    }

}