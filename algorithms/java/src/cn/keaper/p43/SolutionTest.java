package cn.keaper.p43;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class SolutionTest {


    private Solution solution = new Solution();

    private List<String> cases = Arrays.asList(
            "123","456",
            "2","3",
            "0","0",
            "23","0",
            "123000","23400"
    );

    @Test
    public void multiply() {
        for (int i = 0; i < cases.size(); i+=2) {
            System.out.println(solution.multiply(cases.get(i), cases.get(i+1)));
        }

        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            int num1 = random.nextInt(5000);
            int num2 = random.nextInt(5000);
            System.out.println(num1 * num2 == Integer.parseInt(solution.multiply(String.valueOf(num1),String.valueOf(num2))));
        }
    }
}