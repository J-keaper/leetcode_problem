package cn.keaper.p945;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-increment-to-make-array-unique/
 */
public class Solution {

    private int[] hash = new int[80000];

    /**
     * https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/solution/ji-shu-onxian-xing-tan-ce-fa-onpai-xu-onlogn-yi-ya/
     * Hash线性探测 + 路径压缩
     */
    public int minIncrementForUnique(int[] A) {
        Arrays.fill(hash, -1);
        int res = 0;
        for (int a : A) {
            res += find(a) - a;
        }
        return res;
    }

    /**
     * 找到第一个为空的位置
     */
    private int find(int x){
        if(hash[x] == -1){
            hash[x] = x;
        }else {
            hash[x] = find(hash[x] + 1);
        }
        return hash[x];
    }



    /**
     * 数据范围：0 <= A[i] < 40000
     * 开数组记录每个数出现的次数，然后遍历每个数
     *  如果只出现一次，那么这个数不会变
     *  如果出现了多次，说明这个数需要增加到之后某个没有出现的数
     *  如果出现了0次，说明这个位置之前的重复数可以增加到这个数
     * 我们可以保存当前位置出现的重复数字，也就是需要执行增加操作的数据，然后遍历到没有出现的数时
     * 从集合中取出一个数字，增加到当前数字
     * 优化：
     *  假设遍历到没有出现的数字为a，集合中取出的数字是b，那么增加操作应该执行(b-a)次，
     *  我们可以将(b-a)分为两步，在遍历到a时，预先-a，遍历到b时，执行+b
     *  这样便不需要维护重复出现的数字具体是多少，只需要维护重复数字的个数即可
     *
     * 时间：O(L)，其中 L 的数量级是数组 A 的长度加上其数据范围内的最大值，因为在最坏情况下，数组 A 中的所有数都是数据范围内的最大值。
     * 空间：O(L)
     */
    public int minIncrementForUnique2(int[] A) {
        int[] count = new int[80000];
        for (int i : A) {
            count[i] ++;
        }
        int dup = 0, res = 0;
        for (int i = 0; i < 80000; i++){
            if(count[i] >= 1){
                dup += (count[i] - 1);
                res -= (count[i] - 1) * i;
            }else if (count[i] == 0 && dup > 0){
                dup --;
                res += i;
            }
        }
        return res;
    }


    /**
     * 首先排序，然后遍历数组，如果当前数 <= 前一个数，将当前数增加为前一个数+1，并计算贡献度
     * 时间：O(NLogN)
     */
    public int minIncrementForUnique1(int[] A) {
        Arrays.sort(A);
        int res = 0;
        for (int i = 1; i < A.length; i++) {
            if(A[i] <= A[i-1]){
                res += A[i - 1] + 1 - A[i];
                A[i] = A[i - 1] + 1;
            }
        }
        return res;
    }




}
