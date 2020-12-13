package cn.keaper.review.p24;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListNode;
import cn.keaper.utils.list.integer.ListPrinter;

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
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListPrinter.print(new Solution().swapPairs(ListBuilder.build(1,2,3,4,5,6)));
        ListPrinter.print(new Solution().swapPairs(ListBuilder.build(1,2,3,4,5)));
    }
}
