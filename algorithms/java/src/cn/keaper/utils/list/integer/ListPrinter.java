package cn.keaper.utils.list.integer;

public class ListPrinter {

    public static void print(ListNode head){
        while (head != null){
            System.out.print(head.val);
            head = head.next;
            if(head != null){
                System.out.print("->");
            }
        }
        System.out.println();
    }
}
