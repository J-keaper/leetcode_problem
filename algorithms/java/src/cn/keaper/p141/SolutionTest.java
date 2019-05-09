package cn.keaper.p141;

import cn.keaper.utils.list.integer.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class SolutionTest {

    private  List<int[]> cases = Arrays.asList(
            new int[]{3,2,0,-4,1},
            new int[]{1,2,0},
            new int[]{1,0},
            new int[]{1,-1},
            new int[]{-1}
    );
    private Solution solution = new Solution();

    @Test
    public void hasCycle() {
        cases.forEach(c -> System.out.println(solution.hasCycle(buildList(Arrays.copyOf(c,c.length-1),c[c.length-1]))));
    }

    @Test
    public void hasCycle1() {
        cases.forEach(c -> System.out.println(solution.hasCycle1(buildList(Arrays.copyOf(c,c.length-1),c[c.length-1]))));
    }


    private ListNode buildList(int[] nodes,int pos){
        ListNode head = new ListNode(-1);
        ListNode next = head,tail = null;
        for (int i = 0; i < nodes.length; i++) {
            next.next = new ListNode(nodes[i]);
            next = next.next;
            if(pos == i){
                tail = next;
            }
        }
        if(pos != -1){
            next.next = tail;
        }
        return head.next;
    }
}