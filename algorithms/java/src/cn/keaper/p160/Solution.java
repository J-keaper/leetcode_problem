package cn.keaper.p160;

import cn.keaper.utils.list.integer.ListNode;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class Solution {

    /**
     * First get two linked list length, we get length difference between two list,marked as [step].
     * Maintain two pointers pA and pB initialized at the head of the longer list and the shorter list, respectively.
     * Let pA forward only [step] steps, pB hold on.
     * Then let them both forward.If at any point pA meets pB, then pA/pB is the intersection node.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0, lengthB = 0;
        ListNode nodeA = headA,nodeB = headB;
        while (nodeA != null){
            nodeA = nodeA.next;
            lengthA ++;
        }
        while (nodeB != null){
            nodeB = nodeB.next;
            lengthB ++;
        }
        if(lengthA > lengthB){
            nodeA = headA;
            nodeB = headB;
        }else {
            nodeB = headA;
            nodeA = headB;
        }
        int step = Math.abs(lengthA - lengthB);
        while (step-- > 0){
            nodeA = nodeA.next;
        }
        while (nodeA != null && nodeB != null){
            if(nodeA == nodeB){
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }

    /**
     * 1. 创建两个指针 pA 和 pB，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历。
     * 2. 当 pA 到达链表的尾部时，将它重定位到链表 B 的头结点; 类似的，当 pB 到达链表的尾部时，将它重定位到链表 A 的头结点。
     * 3. 重复第二步
     * 4. 第二步完成之后两个指针的便是处在相同的相对位置，即一个节点比另一个领先|lenA - lenB|，继续向后，若在某一时刻 pA 和 pB 相遇，则 pA/pB 为相交结点。
     *
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != null && b != null){
            a = a.next;
            b = b.next;
        }
        if(b == null){
            b = headA;
        }else{
            a = headB;
        }
        while (a != null && b != null){
            a = a.next;
            b = b.next;
        }
        if(b == null){
            b = headA;
        }else{
            a = headB;
        }

        while (a != b && a != null && b != null){
            a = a.next;
            b = b.next;
        }
        return a;
    }

}