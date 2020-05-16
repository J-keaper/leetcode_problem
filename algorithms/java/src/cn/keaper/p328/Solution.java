package cn.keaper.p328;

import cn.keaper.utils.list.integer.ListNode;

/**
 * https://leetcode.com/problems/odd-even-linked-list/
 */
public class Solution {

    /**
     * 将原链表拆分成奇数链表和偶数链表
     * 最后将两个链表在前后连接
     */
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode oddDummy = new ListNode(-1), evenDummy = new ListNode(-1);
        ListNode odd = oddDummy, even = evenDummy;
        ListNode cur = head;
        boolean isOdd = true;
        while (cur != null){
            if(isOdd) {
                odd.next = cur;
                odd = odd.next;
            } else {
                even.next = cur;
                even = even.next;
            }
            cur = cur.next;
            isOdd = !isOdd;
        }
        odd.next = evenDummy.next;
        even.next = null;
        return oddDummy.next;
    }




}
