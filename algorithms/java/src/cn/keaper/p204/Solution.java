package cn.keaper.p204;

import java.util.BitSet;

/**
 * https://leetcode.com/problems/count-primes/
 */
public class Solution {

    /**
     * Sieve of Eratosthenes：https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
     *
     * 埃式筛法
     * 如果i是质数，那么 i 的倍数一定是合数
     * 初始化一个数组，表示是否为合数
     * 从2到n遍历，如果一个数i是质数，那么将i的倍数2*i,3*i,...都标记为是合数
     * 因为2*i在 i = 2的时候已经标记过了，为了避免重复计算，可以直接从 i * i 开始标记
     *
     * 最后遍历数组，为false的就是质数，计数即可
     */


    /**
     * 埃式筛法
     */
    public int countPrimes(int n){
        boolean[] notPrime = new boolean[n];
        for(int i = 2 ; i * i <= n ; i ++){
            if(notPrime[i]){
                continue;
            }
            for(int j = i * i ; j < n ; j += i){
                notPrime[j] = true;
            }
        }
        int count = 0;
        for(int i = 2 ; i < n ; i ++){
            if(!notPrime[i]){
                count ++;
            }
        }
        return count;
    }


    /**
     * 埃式筛法
     * 初始化素数个数为n，在标记素数过程中顺便将个数减掉，最后减去0，1两个合数
     */
    public int countPrimes1(int n){
        if(n <= 2){
            return 0;
        }
        int count = n;
        boolean[] notPrime = new boolean[n];
        for(int i = 2 , sqr = 4 ; sqr < n ; i ++ , sqr = i * i){
            if(notPrime[i]){
                continue;
            }
            for(int j = sqr ; j < n ; j += i){
                if(!notPrime[j]){
                    count --;
                    notPrime[j] = true;
                }
            }
        }
        return count - 2;
    }


    /**
     * 埃式筛法，使用BitSet代替数组
     * @deprecated  效率并不高
     */
    @Deprecated
    public int countPrimes2(int n){
        BitSet notPrime = new BitSet();
        for(int i = 2 ; i * i <= n ; i ++){
            if(notPrime.get(i)){
                continue;
            }
            for(int j = i * i ; j < n ; j += i){
                notPrime.set(j);
            }
        }
        int count = 0;
        for(int i = 2 ; i < n ; i ++){
            if(!notPrime.get(i)){
                count ++;
            }
        }
        return count;
    }


    /**
     * 欧式筛法
     * 埃氏筛其实还是存在冗余的标记操作，比如对于 45 这个数，它会同时被 3,5 两个数标记为合数，
     * 因此我们优化的目标是让每个合数只被标记一次，这样时间复杂度即能保证为 O(n)。
     *
     * 相较于埃氏筛，我们多维护一个 primes 数组表示当前得到的质数集合。
     * 我们从小到大遍历，如果当前的数 x 是质数，就将其加入 primes 数组。
     *
     * 另一点与埃氏筛不同的是，「标记过程」不再仅当 x 为质数时才进行，而是对每个整数 x 都进行。
     * 对于整数 xx，我们不再标记其所有的倍数 x*x,x*(x+1),…，
     * 而是只标记质数集合中的数与 x 相乘的数，即 x*primes[0], 即 x*primes[1], 且在发现 x%primes[i] == 0的时候结束当前标记。
     *
     * 核心点在于：如果 x 可以被 primes[i]整除，那么对于合数 y=x⋅primes[i+1]而言，
     * 它一定在后面遍历到 x/primes[i]*primes[i+1]　（y = (x/primes[i]*primes[i+1]) * primes[i]）这个数的时候会被标记，
     * 其他同理，这保证了每个合数只会被其「最小的质因数」筛去，即每个合数被标记一次。
     *
     *
     */
    public int countPrimes3(int n) {
        int[] primes = new int[n]; // 存储质数
        int cnt = 0;  // primes数组个数
        boolean[] notPrime = new boolean[n];
        for(int i = 2 ; i < n ; i ++){
            if(!notPrime[i]){ // 如果是质数，保存到primes数组中
                primes[cnt++] = i;
            }
            for (int j = 0; j < cnt && i * primes[j] < n; j++) {
                notPrime[i * primes[j]] = true; // 已有的质数的倍数标记为合数
                if(i % primes[j] == 0){ // 如果 i 能够整除 primes[j], 那么 (i * primes[j]) 的最小质因数一定不是i
                    // 如果当前数是一个质数的倍数，则跳过标记，因为之后更大的合数会在之后被标记
                    // 比如i = 4的时候 不需要标记 12（12 = 4 * 3），因为 12 会在之后 i = 6 的时候被标记（12 = 6 * 2）
                    break;
                }
            }
        }
        return cnt;
    }
}
