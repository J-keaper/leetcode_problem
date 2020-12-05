package cn.keaper.p621;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<Case> cases = Arrays.asList(
            new Case(new char[]{'A','A','A','B','B','B'}, 2),
            new Case(new char[]{'A','A','A','B','B','B'}, 0),
            new Case(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2)
    );

    @Test
    public void leastInterval() {
        cases.forEach(c -> System.out.println(solution.leastInterval(c.tasks, c.n)));
    }


    static class Case {
        char[] tasks;
        int n;

        Case(char[] tasks, int n) {
            this.tasks = tasks;
            this.n = n;
        }
    }
}