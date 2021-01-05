package cn.keaper.p236;

import cn.keaper.utils.tree.integer.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class Solution {


    /**
     * 我们可以用哈希表存储所有节点的父节点
     * 然后我们就可以利用节点的父节点信息从 p 结点开始不断往上跳，并记录已经访问过的节点
     * 再从 q 节点开始不断往上跳，如果碰到已经访问过的节点，那么这个节点就是我们要找的最近公共祖先。
     *
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        dfs(root, parent);

        Set<TreeNode> visited = new HashSet<>();
        TreeNode cur = p;
        while (cur != null){
            visited.add(cur);
            cur = parent.get(cur);
        }

        cur = q;
        while (cur != null){
            if(visited.contains(cur)){
                return cur;
            }
            cur = parent.get(cur);
        }

        return null;
    }

    private void dfs(TreeNode root, Map<TreeNode, TreeNode> parent){
        if(root.left != null){
            parent.put(root.left, root);
            dfs(root.left, parent);
        }
        if(root.right != null){
            parent.put(root.right, root);
            dfs(root.right, parent);
        }
    }



    private TreeNode ans;


    /**
     * 题解：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetc-2/
     *
     * 我们递归遍历整棵二叉树，定义 f_x 表示 x 节点的子树中是否包含 p 节点或 q 节点，如果包含为 true，否则为 false。
     * 那么符合条件的最近公共祖先 x 一定满足如下条件：
     *  (f_lson && f_rson) ∣∣ ((x == p ∣∣ x == q) && (f_lson && f_rson)
     * 其中 lson 和 rson 分别代表 x 节点的左孩子和右孩子。
     *
     *
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        boolean inLeft = dfs(root.left, p, q);
        boolean inRight = dfs(root.right, p, q);
        if((inLeft && inRight) || ((root == p || root == q) && (inLeft || inRight))){
            ans = root;
        }
        return inLeft || inRight || (root == p || root == q);
    }


    /**
     * 递归地在左子树和右子树中找寻找p或者q
     * 如果两边都能找到，说明当前节点就是最近公共祖先
     * 如果左边没找到，则说明p和q都在右子树
     * 如果右边没找到，则说明p和q都在左子树
     *
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root){ // 找到了p或者q，则返回
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null){ // 如果左子树和右子树都找到了那么返回根结点
            return root;
        }
        return left == null ? right : left;  // 返回已经找到的结果
    }
}
