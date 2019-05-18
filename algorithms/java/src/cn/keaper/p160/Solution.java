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
}