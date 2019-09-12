package cn.keaper.p299;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private List<Case> cases = Arrays.asList(
            new Case("",""),
            new Case("1",""),
            new Case("","1"),
            new Case("1807","7810"),
            new Case("1807","7810"),
            new Case("1123","0111"),
            new Case("45132481248584134154015748024","1212024541024654801524850154132455"),
            new Case("48163489146489167468489104600","0210214502410541853746865")
    );

    private Solution solution = new Solution();

    @Test
    public void getHint() {
        cases.forEach(c -> System.out.println(solution.getHint(c.secret,c.guess)));
    }


    private class Case {
        String secret;
        String guess;

        Case(String secret, String guess) {
            this.secret = secret;
            this.guess = guess;
        }
    }
}