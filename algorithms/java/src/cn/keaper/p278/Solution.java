package cn.keaper.p278;

/**
 * https://leetcode.com/problems/first-bad-version/
 */
public class Solution extends VersionControl {

    /**
     * Binary Search
     */
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r){
            int m = (l + r) >>> 1;
            if(isBadVersion(m)){
                r = m;
            }else {
                l = m + 1;
            }
        }
        return r;
    }

    public int firstBadVersion1(int n) {
        int l = 1, r = n;
        while (l + 1 < r){
            int m = (l + r) >>> 1;
            if(isBadVersion(m)){
                r = m;
            }else {
                l = m;
            }
        }
        return isBadVersion(l) ? l : r;
    }

}
class VersionControl{
    private int badVersion;

    void setBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }

    boolean isBadVersion(int version){
        return version >= badVersion;
    }
}
