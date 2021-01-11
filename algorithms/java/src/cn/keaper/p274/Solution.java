package cn.keaper.p274;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/h-index/
 */
public class Solution {

    /**
     * 假设数组从大到小排序，那么对于每一个位置i，都存在(i+1)个数字 >= citations[i]
     * 例如：[6,5,3,1,0]，那么存在
     * 有 1个数 >= 6
     * 有 2个数 >= 5
     * 有 3个数 >= 3
     * ...
     * 有 5个数 >= 0
     *
     *
     * 我们从数组结尾开始遍历，如果发现 citations[i] >= (i+1)，那么表明 找到了(i+1)个数 >= citations[i] >= (i+1)
     * 返回(i+1)即可
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++){
            // 存在 (citations.length - 1 - i) 个数 >= citations[i]
            if((citations.length - i) <= citations[i]){
                return citations.length - i;
            }
        }
        return 0;
    }


    /**
     * 使用计数排序
     */
    public int hIndex1(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        for (int c : citations) {
            count[Math.min(c, n)]++;
        }
        int sum = 0;
        for (int i = n; i > 0; i--){
            sum += count[i]; // sum 表示至少有i次引用的论文数量
            // 最大的满足 sum >= i 的 i 即为结果
            if(sum >= i){
                return i;
            }
        }
        return 0;
    }

}
