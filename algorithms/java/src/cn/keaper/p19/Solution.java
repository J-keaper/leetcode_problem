package cn.keaper.p19;

import cn.keaper.utils.list.integer.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class Solution {


    /**
     * 可以先求出链表长度len,然后再遍历一次，删除len-k个节点
     *
     * 也可以使用双指针遍历一次
     * 两个指针同步位于起点，front指针先走，front走了k步之后，back出发
     * 当front走到末尾，back正好到达len-k位置
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        int step = -1;
        ListNode front = dummy, back = dummy;
        while (front != null){
            front = front.next;
            step++;
            if(step > n){
                back = back.next;
            }
        }
        back.next = back.next.next;
        return dummy.next;
    }


}
