package cn.keaper.p297;

import cn.keaper.utils.tree.integer.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class Codec {


    /**
     * 层序遍历的变种
     * 区别在于对于为空的子节点也要加入结果中
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        List<String> sequence = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll != null){
                sequence.add(String.valueOf(poll.val));
                queue.offer(poll.left);
                queue.offer(poll.right);
            }else{
                sequence.add(null);
            }
        }
        int last = sequence.size() - 1;
        while (sequence.get(last) == null){
            last--;
        }
        return String.join(",", sequence.subList(0, last + 1));
    }

    /**
     * 类似层序遍历的方式，维护一个下标表示已经加入树中的节点
     * 在对已有树进行BFS的同时在树上添加新节点
     */
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Integer[] nodes = Arrays.stream(data.split(","))
                .filter(s -> !s.isEmpty())
                .map(s -> s.equals("null") ? null : Integer.parseInt(s))
                .toArray(Integer[]::new);
        if(nodes.length == 0){
            return null;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(nodes[0]);
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(index >= nodes.length){
                break;
            }
            if(nodes[index] == null){
                poll.left = null;
            }else{
                poll.left = new TreeNode(nodes[index]);
                queue.offer(poll.left);
            }
            index++;

            if(index >= nodes.length){
                return root;
            }
            if(nodes[index] == null){
                poll.right = null;
            }else{
                poll.right = new TreeNode(nodes[index]);
                queue.offer(poll.right);
            }
            index++;
        }
        return root;
    }


}
