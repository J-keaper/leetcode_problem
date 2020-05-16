package cn.keaper.p138;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<Integer[]> cases = Arrays.asList(
            new Integer[]{7,null, 13,0, 11,4 ,10,2, 1,0},
            new Integer[]{1,1, 2,1}
    );

    @Test
    public void copyRandomList() {
        cases.forEach(c -> {
            Node original = build(c);
            print(original);
            Node head = solution.copyRandomList(original);
            print(head);
            System.out.println("------");
        });
    }

    public static void print(Node head){
        Node cur = head;
        while (cur != null){
            System.out.print(cur.val + "," + (cur.random == null ? "null" : cur.random.val) + (cur.next == null ? "" : "->"));
            cur = cur.next;
        }
        System.out.println();
    }

    public static Node build(Integer[] value){
        Node dummy = new Node(-1);
        Node cur = dummy;
        for (int i = 0; i < value.length; i+=2) {
            cur.next = new Node(value[i]);
            cur = cur.next;
        }
        cur = dummy.next;
        for (int i = 0; i < value.length; i+=2) {
            if(value[i+1] == null){
                cur.random = null;
            }else{
                cur.random = get(dummy.next, value[i+1]);
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static Node get(Node head, int index){
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }



}