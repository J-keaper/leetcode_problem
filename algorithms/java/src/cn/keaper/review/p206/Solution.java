package cn.keaper.review.p206;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListNode;
import cn.keaper.utils.list.integer.ListPrinter;

public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, p = head;
        while (p != null){
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return prev;
    }

    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }




    public static void main(String[] args) {
        ListPrinter.print(new Solution().reverseList(ListBuilder.build(1)));
        ListPrinter.print(new Solution().reverseList(ListBuilder.build(1,2)));
        ListPrinter.print(new Solution().reverseList(ListBuilder.build(1,2,3,4,5)));
    }

}