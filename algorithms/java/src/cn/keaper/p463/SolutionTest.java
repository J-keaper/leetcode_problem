package cn.keaper.p463;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();


    private List<int[][]> cases = Arrays.asList(
            new int[][]{
                    {0,1,0,0},
                    {1,1,1,0},
                    {0,1,0,0},
                    {1,1,0,0}
            },
            new int[][]{
                    {0,0,0,0,0},
                    {0,1,1,1,0},
                    {0,0,1,0,0},
                    {0,1,1,1,0},
                    {0,0,0,1,0}
            },

            new int[][]{
                    {0,1,0,0},
                    {1,1,1,0},
                    {0,1,0,0}
            },
            new int[][]{
                    {0,0,0},
                    {0,1,0},
                    {0,0,0}
            },
            new int[][]{
                    {0,1},
                    {1,1},
                    {0,1}
            },
            new int[][]{
                    {1,0},
                    {1,1},
                    {0,1}
            },
            new int[][]{
                    {1,0},
                    {1,1},
            },
            new int[][]{
                    {1}
            },
            new int[][]{
                    {1,1,1},
            },
            new int[][]{
                    {0,1,1},
            },
            new int[][]{
                    {1,1,0},
            },
            new int[][]{
                    {0,1,0},
            },
            new int[][]{
                    {1},
                    {1},
                    {1}
            },
            new int[][]{
                    {0},
                    {1},
                    {1}
            },
            new int[][]{
                    {1},
                    {1},
                    {0}
            },
            new int[][]{
                    {0},
                    {1},
                    {0}
            }
            );

    @Test
    public void islandPerimeter() {
        cases.forEach(c -> System.out.println(
                solution.islandPerimeter(c) + "\t" +
                solution.islandPerimeter1(c) + "\t" +
                solution.islandPerimeter2(c) + "\t" +
                solution.islandPerimeter3(c) + "\t" +
                solution.islandPerimeter4(c)

        ));
    }
}