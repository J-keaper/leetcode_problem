package cn.keaper.p659;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Solution {


    /**
     *
     * 因为数组是递增的，所以如果满足题目条件，因为连续整数子序列长度必须大于等于3
     * 那么对于每个元素，
     * （1）要么是能够在一个连续子序列中的第三位之后；
     * （2）要么是能够在一个连续子序列中的前三位；
     *
     * count[i]记录元素的数量
     * tail[i] 记录以i结尾的连续子序列个数
     * 依次遍历元素，对于每个元素i，
     * 1. 如果count[i] > 0 && tail[i-1] > 0，那么当前元素能够连接到一个大于等于3的连续整数子序列之后组成更长的序列，也就是上面的情况（1）
     * 2. 如果count[i] > 0 && count[i+1] > 0 && count[i+2] > 0， 那么当前元素能够作为一个新序列的起始元素，也就是上面的情况（2）
     * 3. 如果count[i] == 0, 说明这个元素已经处在某个序列中了，因为第二种情况会处理 count[i+1],count[i+2]
     * 4. 如果都不满足的话，则不符合条件
     */
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>(); // 元素数量
        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
        }

        Map<Integer, Integer> tail = new HashMap<>();
        for (int num : nums) {
            if (count.get(num) == 0) continue;
            if (tail.getOrDefault(num - 1, 0) != 0) {
                count.merge(num, -1, Integer::sum);
                tail.merge(num - 1, -1, Integer::sum);
                tail.merge(num, 1, Integer::sum);
            } else if (count.getOrDefault(num + 1, 0) > 0
                    && count.getOrDefault(num + 2, 0) > 0) {
                count.merge(num, -1, Integer::sum);
                count.merge(num + 1, -1, Integer::sum);
                count.merge(num + 2, -1, Integer::sum);
                tail.merge(num + 2, 1, Integer::sum);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isPossible2(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>(); // 元素数量
        for (int num : nums) {
            add(count, num, 1);
        }

        Map<Integer, Integer> tail = new HashMap<>();
        for (int num : nums) {
            if (count.get(num) == 0) continue;
            if (tail.getOrDefault(num - 1, 0) != 0) {
                add(count, num, -1);
                add(tail, num - 1, -1);
                add(tail, num, 1);
            } else if (count.getOrDefault(num + 1, 0) > 0
                    && count.getOrDefault(num + 2, 0) > 0) {
                add(count, num, -1);
                add(count, num + 1, -1);
                add(count, num + 2, -1);
                add(tail, num + 2, 1);
            } else {
                return false;
            }
        }
        return true;
    }


    void add(Map<Integer, Integer> map, int key, int value) {
        Integer cnt = map.get(key);
        if (cnt == null) {
            map.put(key, value);
        } else {
            map.put(key, cnt + value);
        }
    }

}
