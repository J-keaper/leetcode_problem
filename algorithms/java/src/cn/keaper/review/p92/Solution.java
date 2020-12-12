package cn.keaper.review.p92;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListNode;
import cn.keaper.utils.list.integer.ListPrinter;

public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode lt = dummy;  // left tail
        for (int i = 1; i < m; i++) {
            lt = lt.next;
        }
        ListNode mh = lt.next; // mid head

        ListNode prev = null;
        ListNode cur = mh;
        for (int i = m; i <= n; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        lt.next = prev;
        mh.next = cur;

        return dummy.next;
    }


    public static void main(String[] args) {
        ListPrinter.print(new Solution().reverseBetween(ListBuilder.build(1,2,3,4,5), 2,4));
        ListPrinter.print(new Solution().reverseBetween(ListBuilder.build(1,2,3,4,5), 2,2));
        ListPrinter.print(new Solution().reverseBetween(ListBuilder.build(1,2,3,4,5), 2,3));
        ListPrinter.print(new Solution().reverseBetween(ListBuilder.build(1,2,3,4,5), 1,2));
        ListPrinter.print(new Solution().reverseBetween(ListBuilder.build(1,2,3,4,5), 4,5));
    }

}
