package cn.keaper.p14;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        int pos = 0;
        for(int i = 0;;i++){
            for(int j = 0;j < strs.length ; j++){
                if(i >= strs[j].length()){
                    return strs[0].substring(0,pos);
                }
                if(j != 0 && strs[j].charAt(i) != strs[j - 1].charAt(i)){
                    return strs[0].substring(0,pos);
                }
            }
            pos ++;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = new String[]{"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix(strings));
        strings = new String[]{"dog","racecar","car"};
        System.out.println(solution.longestCommonPrefix(strings));
        strings = new String[]{"dog","dog1","dog2"};
        System.out.println(solution.longestCommonPrefix(strings));
        strings = new String[]{};
        System.out.println(solution.longestCommonPrefix(strings));

    }
}