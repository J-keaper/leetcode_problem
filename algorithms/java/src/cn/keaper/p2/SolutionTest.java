package cn.keaper.p2;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListNode;
import cn.keaper.utils.list.integer.ListPrinter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{2,4,3},
            new int[]{5,6,4},
            new int[]{5,6,4,4},
            new int[]{5,6,4},
            new int[]{5,6,4},
            new int[]{5,6,4,4},
            new int[]{3},
            new int[]{5,6,4,4},
            new int[]{5,6,4},
            new int[]{4},
            new int[]{4,5},
            new int[]{4,5},
            new int[]{1},
            new int[]{9,9}
    );

    @Test
    public void addTwoNumbers() {
        for (int i = 0; i < cases.size(); i+=2) {
            ListNode head = solution.addTwoNumbers(ListBuilder.build(cases.get(i)),ListBuilder.build(cases.get(i+1)));
            ListPrinter.print(head);
        }
    }
}