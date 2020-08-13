package cn.keaper.p130;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<char[][]> cases = Arrays.asList(
            new char[][]{{'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'}, {'X','O','X','X'}},
            new char[][]{{'X','X','X','X'}, {'X','O','O','O'}, {'X','X','O','X'}, {'X','O','X','X'}}
    );


    @Test
    public void solve() {
        cases.forEach(c -> {
            print(c);
            solution.solve(c);
            print(c);
        });
    }

    void print(char[][] chars){
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


}