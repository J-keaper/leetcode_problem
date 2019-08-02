package cn.keaper.utils.list.integer;

public class ListBuilder {

    public static ListNode build(int... valList){
        ListNode head = new ListNode(-1);
        ListNode node = head;
        for (int i = 0; i < valList.length; i++) {
            node.next = new ListNode(valList[i]);
            node = node.next;
        }
        return head.next;
    }
}
