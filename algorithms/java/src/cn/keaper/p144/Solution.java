package cn.keaper.p144;

import cn.keaper.utils.tree.integer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class Solution {


// ****************方法一，递归
    private List<Integer> res;

    public List<Integer> preorderTraversal(TreeNode root) {
        res = new LinkedList<>();
        preOrder(root);
        return res;
    }

    private void preOrder(TreeNode root) {
        if(root != null){
            res.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }


// ****************方法二，迭代
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode top = stack.pop();
            if(top != null){
                res.add(top.val);
                stack.push(top.right);
                stack.push(top.left);
            }
        }
        return res;
    }

// ****************方法三，一种通用方法

    /**
     * 其实是模拟函数调用，每次从栈顶弹出一个元素相当于取得此次函数调用的参数
     * 而对参数再次入栈是为了之后将其打印出来，所以用一个标识位区分
     *
     * 三种遍历方式只是入栈顺序不同
     */
    public List<Integer> preorderTraversal3(TreeNode root){
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
                stack.push(new WrapperNode(top.treeNode.left,false));
                stack.push(new WrapperNode(top.treeNode,true));
            } else {
                res.add(top.treeNode.val);
            }
        }
        return res;
    }

    /**
     * 其实也可以继承自TreeNode
     */
    private static class WrapperNode{
        TreeNode treeNode;
        boolean accessed;

        WrapperNode(TreeNode treeNode, boolean accessed) {
            this.treeNode = treeNode;
            this.accessed = accessed;
        }
    }

}
