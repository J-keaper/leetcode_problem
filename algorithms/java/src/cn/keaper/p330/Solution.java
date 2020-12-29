package cn.keaper.p330;

/**
 * https://leetcode.com/problems/patching-array/
 */
public class Solution {

    /**
     * https://leetcode-cn.com/problems/patching-array/solution/an-yao-qiu-bu-qi-shu-zu-tan-xin-suan-fa-b4bwr/
     *
     * 假设数组中前k个数字能组成的数字范围是[1,total)，
     * 当我们添加数组中第k+1个数字nums[k](数组的下标是从0开始的)的时候
     * 范围就变成了[1, total) U [1+nums[k], total+nums[k]) U [nums[k],nums[k]]，这是个并集，
     * 可以合并成[1, total) U [nums[k], total+nums[k])
     * 例如：[1,4) 当添加 6 之后的范围是[1,4) U [7,10)
     *
     * 1. 如果左边的total < nums[k]，那么他们中间肯定会有空缺，不能构成完整的[1，total+nums[k])。
     *    这个时候我们需要添加一个数字total。先构成一个更大的范围[1，total*2)。
     *    之所以添加total是因为这样能够尽可能扩大数字覆盖范围，减少重复，例如[1,4)添加4可以将范围扩展到[1,4) U (4,8) = [1,8)
     * 2. 如果左边的total >= nums[k]，那么就可以构成完整的[1，total+nums[k])，就不需要在添加数字了。
     */
    public int minPatches(int[] nums, int n) {
        int i = 0, miss = 0;
        long x = 1;
        while (x <= n){
            if(i < nums.length && nums[i] <= x){
                x += nums[i];
                i++;
            }else {
                x = x * 2;
                miss++;
            }
        }
        return miss;
    }
}
