package cn.keaper.p257;

import cn.keaper.utils.tree.integer.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class Solution {

    private List<String> paths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        paths.clear();
        if(root == null){
            return paths;
        }
        binaryTreePath(root,"");
        return paths;
    }

    private void binaryTreePath(TreeNode root,String path){
        if(root.left == null && root.right == null){
            paths.add(path + root.val);
            return;
        }
        if(root.left != null){
            binaryTreePath(root.left, path + root.val + "->");
        }
        if(root.right != null){
            binaryTreePath(root.right, path + root.val + "->");
        }
    }

}
