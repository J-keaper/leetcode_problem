package cn.keaper.review.p70;

public class Solution {

    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int a = 1, b = 2;
        while (n >= 3){
            int c = a + b;
            a = b;
            b = c;
            n--;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(1));
        System.out.println(new Solution().climbStairs(2));
        System.out.println(new Solution().climbStairs(3));
        System.out.println(new Solution().climbStairs(4));
        System.out.println(new Solution().climbStairs(5));
        System.out.println(new Solution().climbStairs(45));
    }
}
