package cn.keaper.p94;

import cn.keaper.utils.tree.integer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class Solution {



// **************** 方法一，递归
    private List<Integer> res;

    public List<Integer> inorderTraversal(TreeNode root) {
        res = new LinkedList<>();
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            res.add(root.val);
            inOrder(root.right);
        }
    }

// **************** 方法二，迭代

    /**
     * 每到一个节点 A，因为根的访问在中间，将 A 入栈。然后遍历左子树，接着访问 A，最后遍历右子树。
     * 在访问完 A 后，A 就可以出栈了。因为 A 和其左子树都已经访问完成。
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
    

// ****************方法三，一种通用方法

    /**
     * @see cn.keaper.p94.Solution#inorderTraversal3(TreeNode)
     */
    public List<Integer> inorderTraversal3(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<WrapperNode> stack = new Stack<>();
        stack.push(new WrapperNode(root, false));
        while (!stack.isEmpty()){
            WrapperNode top = stack.pop();
            if (top.treeNode == null) {
                continue;
            }
            if(!top.accessed){
                stack.push(new WrapperNode(top.treeNode.right,false));
                stack.push(new WrapperNode(top.treeNode,true));
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
