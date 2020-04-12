package cn.keaper.p322;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<Case> cases = Arrays.asList(
            new Case(new int[]{1,2,5}, 11),
            new Case(new int[]{1,7,10}, 14),
            new Case(new int[]{1,7,10}, 15),
            new Case(new int[]{1,3,5,7,10}, 15),
            new Case(new int[]{8,5}, 14)
    );

    @Test
    public void coinChange() {
        cases.forEach(c -> System.out.println(solution.coinChange(c.coins,c.amount)));
    }

    private static class Case {
        int [] coins;
        int amount;

        public Case(int[] coins, int amount) {
            this.coins = coins;
            this.amount = amount;
        }
    }
}