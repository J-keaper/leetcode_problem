package cn.keaper.p86;

import cn.keaper.utils.list.integer.ListNode;

/**
 * https://leetcode.com/problems/partition-list/
 */
public class Solution {

    /**
     * 与 P328[https://leetcode.com/problems/odd-even-linked-list/] 思想一样
     * 拆分成两个链表，最后合并
     */
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(-1), bigDummy = new ListNode(-1);
        ListNode small = smallDummy, big = bigDummy;
        ListNode cur = head;
        while (cur != null){
            if(cur.val < x){
                small.next = cur;
                small = small.next;
            }else {
                big.next = cur;
                big = big.next;
            }
            cur = cur.next;
        }
        small.next = bigDummy.next;
        big.next = null;
        return smallDummy.next;
    }

}
