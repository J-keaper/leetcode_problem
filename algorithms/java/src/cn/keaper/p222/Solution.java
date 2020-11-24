package cn.keaper.p222;

import cn.keaper.utils.tree.integer.TreeNode;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class Solution {

    /**
     * 对于完全二叉树，我们可以对最后一层做二分查找以提高效率
     * 按照层序遍历对节点进行编号，根节点为1
     * 求出高度h,那么最后一层的节点编号范围就是[2^(h-1), 2^h - 1]
     * 如果判断其中一个节点是否存在呢，按照每个节点编号的二进制，从最高位的下一位开始，为0表示向左，为1表示向右
     * 直到最后一层，如果能够遍历所有位，那么节点存在，否则不存在
     */
    public int countNodes1(TreeNode root) {
        int h = getHeight(root);
        if(h == 0){
            return 0;
        }
        int l = 1 << (h - 1) , r = (1 << h) - 1;
        while (l + 1 < r){
            int mid = (l + r) >> 1;
            if(exist(root, h, mid)){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return exist(root,h, r) ? r : l;
    }


    /**
     * 求出树的高度
     */
    int getHeight(TreeNode root){
        int h = 0;
        TreeNode node = root;
        while (node != null){
            node = node.left;
            h++;
        }
        return h;
    }

    /**
     * 判断某个节点是否存在
     * @param index 按照层序遍历的节点序号,根结点为1
     */
    boolean exist(TreeNode root, int h, int index){
        TreeNode node = root;
        int mask = 1 << (h - 2);
        while (mask != 0){
            if(node == null){
                return false;
            }
            if((mask & index) == 0){
                node = node.left;
            }else {
                node = node.right;
            }
            mask >>= 1;
        }
        return node != null;
    }



    public int countNodes(TreeNode root) {
        return root == null ? 0 : 1 + countNodes(root.left) + countNodes(root.right);
    }
}
