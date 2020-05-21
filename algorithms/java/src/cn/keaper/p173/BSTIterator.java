package cn.keaper.p173;

import cn.keaper.utils.tree.integer.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * 实际上是实现二叉搜索树的中序遍历,这里使用栈模拟
 */
public class BSTIterator {

    private Stack<TreeNode> stack;
    private TreeNode cur;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        cur = root;
    }

    /** @return the next smallest number */
    public int next() {
        while (cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int res = cur.val;
        cur = cur.right;
        return res;

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }

}
