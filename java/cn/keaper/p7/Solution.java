package cn.keaper.p7;


/**
 * https://leetcode.com/problems/reverse-integer/
 */
class Solution {
    public int reverse(int x) {
        long source = x , target = 0;
        while (source != 0){
            target = target * 10 + source % 10;
            source = source / 10;
        }
        if(target > Integer.MAX_VALUE || target < Integer.MIN_VALUE){
            return 0;
        }
        return (int) target;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(0));
        System.out.println(new Solution().reverse(4548484));
        System.out.println(new Solution().reverse(-454848484));
        System.out.println(new Solution().reverse(2147483647));
        System.out.println(new Solution().reverse(2147483641));
        System.out.println(new Solution().reverse(-2147483648));
        System.out.println(new Solution().reverse(-2147483641));
    }
}