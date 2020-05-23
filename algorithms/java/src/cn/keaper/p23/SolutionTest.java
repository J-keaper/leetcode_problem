package cn.keaper.p23;

import cn.keaper.utils.list.integer.ListBuilder;
import cn.keaper.utils.list.integer.ListNode;
import cn.keaper.utils.list.integer.ListPrinter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[][]> cases = Arrays.asList(
            new int[][]{{1,4,5},{1,3,4},{2,6}},
            new int[][]{{1,4,5},{1,3,4},{2,6},{3,4,5,6}}
    );

    @Test
    public void mergeKLists() {
        cases.forEach(c -> {
            ListNode[] listNodes = Arrays.stream(c).map(ListBuilder::build).toArray(ListNode[]::new);
            ListPrinter.print(solution.mergeKLists(listNodes));
        });
    }
}