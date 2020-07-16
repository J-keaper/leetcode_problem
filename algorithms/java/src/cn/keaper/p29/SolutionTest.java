package cn.keaper.p29;

import org.junit.Test;

import java.util.stream.IntStream;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void divide() {
        int[] fs = new int[]{3,2,1,-1,-2,-3,Integer.MAX_VALUE,Integer.MIN_VALUE};
        for (int f : fs) {
            IntStream.of(15,35,56,-67,-34,-456, Integer.MAX_VALUE, Integer.MIN_VALUE).forEach(i -> {
                System.out.print(i + "/" + f + " = ");
                System.out.print(solution.divide(i, f));
                System.out.print("\t");
                System.out.print((long) i / (long) f);
                System.out.println();
            });
        }
    }

}
