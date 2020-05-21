package cn.keaper.p173;

import cn.keaper.utils.tree.integer.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * 使用递归，首先将中序遍历序列计算出来，然后返回
 */
public class BSTIterator1 {

    private List<Integer> inOrderList;
    private int index;

    /**
     * 实际上是实现二叉搜索树的中序遍历
     */
    public BSTIterator1(TreeNode root) {
        inOrderList = new ArrayList<>();
        _inOrder(root);
        index = 0;
    }

    private void _inOrder(TreeNode root){
        if(root == null){
            return;
        }
        _inOrder(root.left);
        inOrderList.add(root.val);
        _inOrder(root.right);
    }


    /** @return the next smallest number */
    public int next() {
        return inOrderList.get(index++);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !inOrderList.isEmpty() && index < inOrderList.size();
    }

}
