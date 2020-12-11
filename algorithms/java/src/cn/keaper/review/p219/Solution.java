package cn.keaper.review.p219;

import java.util.HashMap;

public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> index = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(index.containsKey(nums[i])){
                if(i - index.get(nums[i]) <= k){
                    return true;
                }
            }
            index.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println(new Solution().containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        System.out.println(new Solution().containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }

}
