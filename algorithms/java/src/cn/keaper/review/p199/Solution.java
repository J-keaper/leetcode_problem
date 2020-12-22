package cn.keaper.review.p199;

import cn.keaper.utils.tree.integer.TreeBuilder;
import cn.keaper.utils.tree.integer.TreeNode;

import java.util.*;

public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Integer right = null;
            while (!queue.isEmpty() && size-- > 0){
                TreeNode poll = queue.poll();
                if(poll != null){
                    right = poll.val;
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }
            }
            if(right != null){
                res.add(right);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().rightSideView(TreeBuilder.buildTree(new Integer[]{1,2,3,null,5,null,4})).toArray(new Integer[]{})));

        System.out.println(Arrays.toString(new Solution().rightSideView(TreeBuilder.buildTree(new Integer[]{1,2})).toArray(new Integer[]{})));

    }


}
