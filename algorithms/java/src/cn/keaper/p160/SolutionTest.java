package cn.keaper.p160;

import cn.keaper.utils.list.integer.ListNode;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    private Input[] cases = new Input[]{
            new Input(new int[]{4,1,8,4,5},new int[]{5,0,1,8,4,5},2,3),
            new Input(new int[]{0,9,1,2,4},new int[]{3,2,4},3,1),
            new Input(new int[]{2,6,4},new int[]{1,5},3,2),
            new Input(new int[]{},new int[]{},0,0),
            new Input(new int[]{},new int[]{1,2},0,2),
            new Input(new int[]{3,4},new int[]{},2,0),
            new Input(new int[]{1,2,3,4},new int[]{3,4},2,0),
            new Input(new int[]{3,4},new int[]{1,2,3,4},0,2),
    };

    private Solution solution = new Solution();

    @Test
    public void getIntersectionNode() {
        Arrays.stream(cases).forEach(c -> {
            ListNode[] nodes = buildInput(c);
            ListNode res = solution.getIntersectionNode(nodes[0],nodes[1]);
            System.out.println(res == null ? "null" : res.val);
        });

        Arrays.stream(cases).forEach(c -> {
            ListNode[] nodes = buildInput(c);
            ListNode res = solution.getIntersectionNode1(nodes[0],nodes[1]);
            System.out.println(res == null ? "null" : res.val);
        });

    }

    private ListNode[] buildInput(Input input){
        ListNode A = new ListNode(-1), B = new ListNode(-1);
        ListNode nodeA = A, nodeB = B;
        int i = 0 , j = 0;
        while (i < input.listA.length && i < input.skipA){
            nodeA.next = new ListNode(input.listA[i]);
            nodeA = nodeA.next;
            i ++;
        }
        while (j < input.listB.length && j < input.skipB){
            nodeB.next = new ListNode(input.listB[j]);
            nodeB = nodeB.next;
            j ++;
        }
        while (i < input.listA.length){
            nodeA.next = nodeB.next = new ListNode(input.listA[i]);
            nodeA = nodeA.next;
            nodeB = nodeB.next;
            i ++;
        }
        return new ListNode[]{A.next,B.next};
    }

    private static class Input{
        int[] listA;
        int[] listB;
        int skipA;
        int skipB;

        Input(int[] listA, int[] listB, int skipA, int skipB) {
            this.listA = listA;
            this.listB = listB;
            this.skipA = skipA;
            this.skipB = skipB;
        }
    }

}