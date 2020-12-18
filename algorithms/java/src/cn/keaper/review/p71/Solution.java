package cn.keaper.review.p71;

public class Solution {

    public String simplifyPath(String path) {
        String[] split = path.split("/");
        String[] store = new String[split.length];
        int count = 0;

        for (String s : split) {
            if (s.isEmpty() || s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                if (count > 0) {
                    count--;
                }
                continue;
            }
            store[count++] = s;
        }
        if(count == 0){
            return "/";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < count; i++) {
            res.append("/").append(store[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/home/"));
        System.out.println(new Solution().simplifyPath("/../"));
        System.out.println(new Solution().simplifyPath("/home//foo/"));
        System.out.println(new Solution().simplifyPath("/a/./b/../../c/"));
        System.out.println(new Solution().simplifyPath("/a/../../b/../c//.//"));
        System.out.println(new Solution().simplifyPath("/a//b////c/d//././/.."));
    }
}
