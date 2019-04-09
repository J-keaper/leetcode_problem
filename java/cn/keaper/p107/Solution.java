package cn.keaper.p107;

import cn.keaper.tree.integer.TreeBuilder;
import cn.keaper.tree.integer.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class Solution {

    /**
     * 遍历，与levelOrderBottom3一致，不过直接写到对应位置，不需要翻转
     * 0ms
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> level = new ArrayList<>();
        levelOrderBottom(root,level,0);
        return level;
    }

    public void levelOrderBottom(TreeNode root, List<List<Integer>> list, int level) {
        if(root == null){
            return;
        }
        if(list.size() <= level){
            list.add(0,new ArrayList<>());
        }
        levelOrderBottom(root.left,list,level + 1);
        levelOrderBottom(root.right,list,level + 1);
        list.get(list.size() - 1 - level).add(root.val);
    }

    /**
     * 遍历，传递一个level记录当前层数，直接写到结果中对应层数的list中，最后翻转一次顺序
     * 1ms
     */
    public List<List<Integer>> levelOrderBottom3(TreeNode root) {
        List<List<Integer>> level = new ArrayList<>();
        levelOrderBottom3(root,level,0);
        Collections.reverse(level);
        return level;
    }

    public void levelOrderBottom3(TreeNode root, List<List<Integer>> list, int level) {
        if(root == null){
            return;
        }
        if(list.size() <= level){
            list.add(new ArrayList<>());
        }
        levelOrderBottom3(root.left,list,level + 1);
        levelOrderBottom3(root.right,list,level + 1);
        list.get(level).add(root.val);
    }


    /**
     * 层序遍历的思想，用队列来遍历每个节点，但是需要能够区分出哪些节点是同一层的，所以用一个计数器保存当前层的数量
     * 1ms
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> level = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> value = new ArrayList<>();
            int levelSize = queue.size();
            while (levelSize-- > 0){
                TreeNode node = queue.poll();
                if(node == null){
                    continue;
                }
                value.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if(!value.isEmpty()){
                level.add(0,value);
            }
        }
        return level;
    }

    /**
     * 遍历当前层，加入结果中，同时得到下一层的点，依次遍历每一层
     * 33ms
     */
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> level = new ArrayList<>();
        List<TreeNode> current = new ArrayList<>();
        current.add(root);
        while (!current.isEmpty()){
            List<TreeNode> next = new ArrayList<>();
            List<Integer> value = new ArrayList<>();
            current.forEach(node -> {
                if(node == null){
                    return;
                }
                value.add(node.val);
                next.add(node.left);
                next.add(node.right);
            });
            current = next;
            if(!value.isEmpty()){
                level.add(value);
            }
        }
        Collections.reverse(level);
        return level;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.levelOrderBottom(TreeBuilder.buildTree(new Integer[]{})));
        System.out.println(solution.levelOrderBottom(TreeBuilder.buildTree(new Integer[]{1})));
        System.out.println(solution.levelOrderBottom(TreeBuilder.buildTree(new Integer[]{1,2})));
        System.out.println(solution.levelOrderBottom(TreeBuilder.buildTree(new Integer[]{1,2,3})));
        System.out.println(solution.levelOrderBottom(TreeBuilder.buildTree(new Integer[]{1,2,3,4})));
        System.out.println(solution.levelOrderBottom(TreeBuilder.buildTree(new Integer[]{3,9,20,null,null,15,7})));
        System.out.println(solution.levelOrderBottom(TreeBuilder.buildTree(new Integer[]{3,9,20,5,null,null,15,7,10,null,null,20})));
        System.out.println(solution.levelOrderBottom(TreeBuilder.buildTree(new Integer[]{3,9,20,5,null,null,15,null,7,10,null,null,20})));
        System.out.println(solution.levelOrderBottom(TreeBuilder.buildTree(new Integer[]{3,9,20,5,null,null,15,null,null,null,7,10,null,null,20})));
    }
}
//        []
//        [[1]]
//        [[2], [1]]
//        [[2, 3], [1]]
//        [[4], [2, 3], [1]]
//        [[15, 7], [9, 20], [3]]
//        [[20], [7, 10], [5, 15], [9, 20], [3]]
//        [[20], [7, 10], [5, 15], [9, 20], [3]]
//        [[20], [10], [7], [5, 15], [9, 20], [3]]