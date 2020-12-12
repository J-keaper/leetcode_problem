package cn.keaper.review.p83;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListNode;
import cn.keaper.utils.list.integer.ListPrinter;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null){
            if(cur.next.val == cur.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListPrinter.print(new Solution().deleteDuplicates(ListBuilder.build(1)));
        ListPrinter.print(new Solution().deleteDuplicates(ListBuilder.build(1,1)));
        ListPrinter.print(new Solution().deleteDuplicates(ListBuilder.build(1,1,2)));
        ListPrinter.print(new Solution().deleteDuplicates(ListBuilder.build(1,1,2,2)));
    }
}
