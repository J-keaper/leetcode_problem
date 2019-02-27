package cn.keaper.p21;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
class Solution {

    /**
     * 归并排序中的归并部分
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode current = head;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            current = current.next;
        }
        if(l1 != null){
            current.next = l1;
        }
        if(l2 != null){
            current.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[] a = new int[]{13};
        int[] b = new int[]{8};
        ListNode l1 = new ListNode(-1),l2 = new ListNode(-1);
        ListNode head1 = l1,head2 = l2;
        for (int i = 0; i < a.length ; i++){
            l1.next = new ListNode(a[i]);
            l1 = l1.next;
        }
        for (int i = 0 ; i < b.length ; i++){
            l2.next = new ListNode(b[i]);
            l2 = l2.next;
        }
        Solution solution = new Solution();
        ListNode res = solution.mergeTwoLists(head1.next,head2.next);
        while (res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
