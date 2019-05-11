package cn.keaper.p142;

import cn.keaper.utils.list.integer.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class Solution {


    /**
     * Solution：http://keaper.cn/2017/08/20/%E7%AE%97%E6%B3%95%E9%A2%98%E7%9B%AE/%E5%89%91%E6%8C%87offer/23.%20%E9%93%BE%E8%A1%A8%E4%B8%AD%E7%8E%AF%E7%9A%84%E5%85%A5%E5%8F%A3%E7%BB%93%E7%82%B9/
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head, fast = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
