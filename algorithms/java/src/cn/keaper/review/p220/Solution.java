package cn.keaper.review.p220;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution {


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) {
            return false;
        }
        Map<Long, Long> bucket = new HashMap<>(); // 桶下标 -> 数字
        long bucketWidth = (long) t + 1;
        for (int i = 0; i < nums.length; i++) {
            long index = getBucketIndex(nums[i], bucketWidth);
            if (bucket.containsKey(index)) {
                return true;
            }
            if (bucket.containsKey(index - 1) && Math.abs(bucket.get(index - 1) - nums[i]) <= t) {
                return true;
            }
            if (bucket.containsKey(index + 1) && Math.abs(bucket.get(index + 1) - nums[i]) <= t) {
                return true;
            }
            bucket.put(index, (long) nums[i]);
            if (i >= k) {
                bucket.remove(getBucketIndex(nums[i - k], bucketWidth));
            }
        }
        return false;
    }


    public long getBucketIndex(long ele, long width) {
        if (ele >= 0) {
            return ele / width;
        }
        return (ele + 1) / width - 1;
    }

    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceil = set.ceiling((long) nums[i]), floor = set.floor((long) nums[i]);
            if (ceil != null && Math.abs(ceil - nums[i]) <= t) {
                return true;
            }
            if (floor != null && Math.abs(floor - nums[i]) <= t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(new Solution().containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        System.out.println(new Solution().containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));

        System.out.println(new Solution().containsNearbyAlmostDuplicate1(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(new Solution().containsNearbyAlmostDuplicate1(new int[]{1, 0, 1, 1}, 1, 2));
        System.out.println(new Solution().containsNearbyAlmostDuplicate1(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }

}
