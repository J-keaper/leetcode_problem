package cn.keaper.p83;

import cn.keaper.utils.list.integer.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class Solution {

    /**
     * 如果当前节点和下一个节点的值相等，则更改当前节点的指向
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null){
            if(node.val == node.next.val){
                node.next = node.next.next;
            }else {
                node =  node.next;
            }
        }
        return head;
    }

    /**
     * 保存前一个节点，比较当前节点与前一个节点的值，如果相等，前一个节点指向下一个节点
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(head.val + 1);
        dummy.next = head;
        ListNode prev = dummy, cur = head;
        while (cur != null){
            if(prev.val == cur.val){
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

}
