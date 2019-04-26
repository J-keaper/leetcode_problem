package cn.keaper.p21;

import cn.keaper.utils.list.integer.ListNode;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void mergeTwoLists() {
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