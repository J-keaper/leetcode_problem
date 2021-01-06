package cn.keaper.review.p147;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListNode;
import cn.keaper.utils.list.integer.ListPrinter;

public class Solution {


    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode node = head;
        while (node != null){
            ListNode pos = findPos(dummy, node.val);
            ListNode next = node.next;
            node.next = pos.next;
            pos.next = node;
            node = next;
        }
        return dummy.next;
    }



    public ListNode findPos(ListNode head, int insert){
        ListNode cur = head;
        while (cur.next != null && cur.next.val < insert){
            cur = cur.next;
        }
        return cur;
    }


    public static void main(String[] args) {
        ListPrinter.print(new Solution().insertionSortList(ListBuilder.build(1,4,3,5,6,2)));
        ListPrinter.print(new Solution().insertionSortList(ListBuilder.build()));
        ListPrinter.print(new Solution().insertionSortList(ListBuilder.build(1)));
        ListPrinter.print(new Solution().insertionSortList(ListBuilder.build(2,1)));
    }

}
