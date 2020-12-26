package cn.keaper.p113;

import cn.keaper.utils.tree.integer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 */
public class Solution {


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return new LinkedList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        pathSum(root, sum, path, res);
        return res;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
        if(root.left == null && root.right == null){
            if(root.val == sum){
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }

        if(root.right != null){
            path.add(root.val);
            pathSum(root.right, sum - root.val, path, res);
            path.remove(path.size() - 1);
        }
        if(root.left != null){
            path.add(root.val);
            pathSum(root.left, sum - root.val, path, res);
            path.remove(path.size() - 1);
        }
    }

}
