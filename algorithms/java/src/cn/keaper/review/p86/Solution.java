package cn.keaper.review.p86;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListNode;
import cn.keaper.utils.list.integer.ListPrinter;

public class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode lessDummy = new ListNode(-1), greaterDummy = new ListNode(-1);
        ListNode less = lessDummy, greater = greaterDummy;

        ListNode cur = head;
        while (cur != null){
            if(cur.val < x){
                less.next = cur;
                less = less.next;
            }else {
                greater.next = cur;
                greater = greater.next;
            }
            cur = cur.next;
        }

        less.next = greaterDummy.next;
        greater.next = null;

        return lessDummy.next;
    }

    public static void main(String[] args) {
        ListPrinter.print(new Solution().partition(ListBuilder.build(1,4,3,2,5,2), 3));
    }
}
