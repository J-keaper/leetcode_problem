package cn.keaper.p109;

import cn.keaper.utils.list.integer.ListNode;
import cn.keaper.utils.tree.integer.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class Solution {

    /**
     * 链表没有办法进行随机访问，我们只能找到中间节点然后切成两个链表进行递归
     * 时间复杂度：O(N*LogN)
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = head, fast = head, prev = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(dummy.next);
        root.right = sortedListToBST(slow.next);

        return root;
    }

    private ListNode global;

    /**
     * 由于构造出的二叉搜索树的中序遍历结果就是链表本身，因此我们可以将分治和中序遍历结合起来，减少时间复杂度。
     * 递归的时候先递归处理左子树，然后再对根结点赋值，因为先递归了左子树，所以此时正好遍历到链表的中间节点
     */
    public TreeNode sortedListToBST1(ListNode head) {
        global = head;
        int len = getLen(head);
        return sortedListToBST1(0, len - 1);
    }

    int getLen(ListNode head){
        int l = 0;
        while (head != null){
            l++;
            head = head.next;
        }
        return l;
    }

    TreeNode sortedListToBST1(int l, int r) {
        if(l > r){
            return null;
        }
        int m = (l + r) >>> 1;
        TreeNode root = new TreeNode();
        root.left = sortedListToBST1(l, m - 1);
        root.val = global.val;
        global = global.next;
        root.right = sortedListToBST1(m + 1, r);
        return root;
    }

}