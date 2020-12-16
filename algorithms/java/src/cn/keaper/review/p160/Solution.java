package cn.keaper.review.p160;

import cn.keaper.utils.list.integer.ListNode;

public class Solution {

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != null && b != null){
            a = a.next;
            b = b.next;
        }
        if(b == null){
            b = headA;
        }else{
            a = headB;
        }
        while (a != null && b != null){
            a = a.next;
            b = b.next;
        }
        if(b == null){
            b = headA;
        }else{
            a = headB;
        }

        while (a != b && a != null && b != null){
            a = a.next;
            b = b.next;
        }
        return a;
    }
}
