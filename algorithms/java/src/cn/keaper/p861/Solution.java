package cn.keaper.p861;

/**
 * https://leetcode.com/problems/score-after-flipping-matrix/
 */
public class Solution {


    /**
     * 对于每行来说，保证首位为1能是最后的数更大，即使第一位是0，后面所有位都为1，翻转行之后也会使得结果加一，所以首先保证每一行第一列都为1
     *
     * 然后对于之后的列，使得1的个数大于0的个数可以使得最后结果更大，所以如果0的个数大于1的个数则翻转，否则不翻转
     */
    public int matrixScore(int[][] A) {
        if(A.length == 0){
            return 0;
        }
        int N = A.length, M = A[0].length;
        for (int i = 0; i < N; i++) {
            if(A[i][0] == 0){
                for (int j = 0; j < M; j++) {
                    A[i][j] = (A[i][j] ^ 1) & 1;
                }
            }
        }

        int res = 0;
        for (int i = M - 1; i > 0; i--) {
            int oneCount = 0;
            for (int j = 0; j < N; j++) {
                oneCount += A[j][i];
            }
            res += Math.max(oneCount, N - oneCount) << (M - 1 - i);
        }
        return res + (N << (M - 1));
    }
}
