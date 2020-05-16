package cn.keaper.p25;

import cn.keaper.utils.list.integer.ListNode;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode lastTail = dummy, nextTail = head;
        while (nextTail != null){
            ListNode node = nextTail;
            for (int i = 1; i < k; i++) {
                node = node.next;
                if(node == null) return dummy.next;
            }

            ListNode sp = nextTail, sc = nextTail.next;
            for (int i = 1; sc != null && i < k; i++) {
                ListNode next = sc.next;
                sc.next = sp;
                sp = sc;
                sc = next;
            }
            lastTail.next = sp;
            nextTail.next = sc;

            lastTail = nextTail;
            nextTail = sc;
        }

        return dummy.next;
    }

}
