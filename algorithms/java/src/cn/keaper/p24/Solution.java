package cn.keaper.p24;

import cn.keaper.utils.list.integer.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class Solution {


    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy, cur = head;
        while (cur != null && cur.next != null){
            ListNode next = cur.next.next;
            prev.next = cur.next;
            cur.next.next = cur;
            cur.next = next;

            prev = cur;
            cur = next;
        }
        return dummy.next;
    }

}
