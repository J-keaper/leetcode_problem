package cn.keaper.p2;

import cn.keaper.utils.list.integer.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class Solution {

    /**
     * 模拟加法操作，注意最后进位可能会多比原数多一位
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        int carry = 0;
        ListNode cur = dummy;
        while (l1 != null || l2 != null){
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            cur.next = new ListNode((v1 + v2 + carry) % 10);
            carry = (v1 + v2 + carry) / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            cur = cur.next;
        }
        if(carry > 0){
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
