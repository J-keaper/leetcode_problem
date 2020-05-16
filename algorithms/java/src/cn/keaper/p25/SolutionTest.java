package cn.keaper.p25;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListNode;
import cn.keaper.utils.list.integer.ListPrinter;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{1,2,3,4,5,6,7,8,9},
            new int[]{1,2,3,4,5,6,7,8},
            new int[]{1,2,3},
            new int[]{1,2},
            new int[]{1},
            new int[]{}
    );

    @Test
    public void reverseKGroup() {
        cases.forEach(c -> {
            for (int i = 1; i <= c.length; i++) {
                ListNode head = solution.reverseKGroup(ListBuilder.build(c),i);
                ListPrinter.print(head);
            }
            System.out.println("------------");
        });
    }
}