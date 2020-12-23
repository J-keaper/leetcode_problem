package cn.keaper.review.p100;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer[]> cases = Arrays.asList(
                new Integer[]{1,2,3},
                new Integer[]{1,2,3},
                new Integer[]{1,2},
                new Integer[]{1,null,2},
                new Integer[]{1,2,1},
                new Integer[]{1,1,2}
        );

        for (int i = 0; i < cases.size(); i+=2) {
            System.out.println(solution.isSameTree(TreeBuilder.buildTree(cases.get(i)), TreeBuilder.buildTree(cases.get(i+1))));
        }


    }
}
