package cn.keaper.review.p142;

import cn.keaper.utils.list.integer.ListNode;

public class Solution {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }

        ListNode front = slow, back = head;
        while (front != back){
            front = front.next;
            back = back.next;
        }
        return front;
    }

}
