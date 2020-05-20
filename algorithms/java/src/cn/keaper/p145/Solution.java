package cn.keaper.p145;

import cn.keaper.utils.tree.integer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class Solution {


// **************** 方法一，递归
    private List<Integer> res;

    public List<Integer> postorderTraversal(TreeNode root) {
        res = new LinkedList<>();
        postOrder(root);
        return res;
    }

    private void postOrder(TreeNode root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            res.add(root.val);
        }
    }

// **************** 方法二，迭代
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode top = stack.pop();
            if(top != null){
                res.add(0, top.val);
                stack.push(top.left);
                stack.push(top.right);
            }
        }
        return res;
    }

// ****************方法三，一种通用方法

    /**
     * @see cn.keaper.p94.Solution#inorderTraversal3(TreeNode)
     */
    public List<Integer> postorderTraversal3(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<WrapperNode> stack = new Stack<>();
        stack.push(new WrapperNode(root, false));
        while (!stack.isEmpty()){
            WrapperNode top = stack.pop();
            if (top.treeNode == null) {
                continue;
            }
            if(!top.accessed){
                stack.push(new WrapperNode(top.treeNode,true));
                stack.push(new WrapperNode(top.treeNode.right,false));
                stack.push(new WrapperNode(top.treeNode.left,false));
            } else {
                res.add(top.treeNode.val);
            }
        }
        return res;
    }

    private static class WrapperNode{
        TreeNode treeNode;
        boolean accessed;

        WrapperNode(TreeNode treeNode, boolean accessed) {
            this.treeNode = treeNode;
            this.accessed = accessed;
        }
    }


}
