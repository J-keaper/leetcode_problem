package cn.keaper.review.p61;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListNode;
import cn.keaper.utils.list.integer.ListPrinter;

public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode cur = head;
        int len = 1;
        while (cur.next != null){
            cur = cur.next;
            len++;
        }
        cur.next = head;
        k %= len;

        int step = len - k;
        ListNode node = head;
        while (step-- > 1){
            node = node.next;
        }
        ListNode newHead = node.next;
        node.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        ListPrinter.print(new Solution().rotateRight(ListBuilder.build(1), 1));
        ListPrinter.print(new Solution().rotateRight(ListBuilder.build(1,2), 1));
        ListPrinter.print(new Solution().rotateRight(ListBuilder.build(1,2), 2));
        ListPrinter.print(new Solution().rotateRight(ListBuilder.build(1,2,3,4,5), 1));
        ListPrinter.print(new Solution().rotateRight(ListBuilder.build(1,2,3,4,5), 2));
        ListPrinter.print(new Solution().rotateRight(ListBuilder.build(1,2,3,4,5), 3));
        ListPrinter.print(new Solution().rotateRight(ListBuilder.build(1,2,3,4,5), 4));
        ListPrinter.print(new Solution().rotateRight(ListBuilder.build(1,2,3,4,5), 5));
        ListPrinter.print(new Solution().rotateRight(ListBuilder.build(1,2,3,4,5), 6));
    }
}
