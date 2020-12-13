package cn.keaper.review.p82;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListNode;
import cn.keaper.utils.list.integer.ListPrinter;

public class Solution {


    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy, cur = head;
        while (cur != null){
            boolean dup = false;
            while (cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
                dup = true;
            }
            if(dup){
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListPrinter.print(new Solution().deleteDuplicates(ListBuilder.build(1,1,2,3,3,3,4,6,5,5)));
        ListPrinter.print(new Solution().deleteDuplicates(ListBuilder.build(1,1,2,3,3,4,4,6,5,5)));
    }
}
