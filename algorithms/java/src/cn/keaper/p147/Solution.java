package cn.keaper.p147;

import cn.keaper.utils.list.integer.ListNode;

/**
 * https://leetcode.com/problems/insertion-sort-list/
 */
public class Solution {

    /**
     * 建立一个虚链表，依次将原链表中的节点插入的新链表中
     */
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);

        for (ListNode cur = head; cur != null;){
            ListNode insert = findInsert(dummy, cur.val);
            ListNode next = cur.next;
            cur.next = insert.next;
            insert.next = cur;
            cur = next;
        }
        return dummy.next;
    }

    private ListNode findInsert(ListNode head, int x){
        ListNode pre = null, cur = head;
        while (cur != null && x >= cur.val){
            pre = cur;
            cur = cur.next;
        }
        return pre;
    }
}
