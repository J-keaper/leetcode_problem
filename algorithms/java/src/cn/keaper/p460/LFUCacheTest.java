package cn.keaper.p460;

import org.junit.Test;

public class LFUCacheTest {

    @Test
    public void testLUCache() {
        LFUCache lFUCache = new LFUCache(2);
        lFUCache.put(1, 1);
        lFUCache.put(2, 2);
        System.out.println(lFUCache.get(1));      // 返回 1
        lFUCache.put(3, 3);   // 去除键 2
        System.out.println(lFUCache.get(2));      // 返回 -1（未找到）
        System.out.println(lFUCache.get(3));      // 返回 3
        lFUCache.put(4, 4);   // 去除键 1
        System.out.println(lFUCache.get(1));      // 返回 -1（未找到）
        System.out.println(lFUCache.get(3));      // 返回 3
        System.out.println(lFUCache.get(4));      // 返回 4

        lFUCache = new LFUCache(0);
        lFUCache.put(0, 0);
        System.out.println(lFUCache.get(0));
    }

    @Test
    public void testLFUCache1(){
        LFUCache1 lFUCache = new LFUCache1(2);
        lFUCache.put(1, 1);
        lFUCache.put(2, 2);
        System.out.println(lFUCache.get(1));      // 返回 1
        lFUCache.put(3, 3);   // 去除键 2
        System.out.println(lFUCache.get(2));      // 返回 -1（未找到）
        System.out.println(lFUCache.get(3));      // 返回 3
        lFUCache.put(4, 4);   // 去除键 1
        System.out.println(lFUCache.get(1));      // 返回 -1（未找到）
        System.out.println(lFUCache.get(3));      // 返回 3
        System.out.println(lFUCache.get(4));      // 返回 4

        lFUCache = new LFUCache1(0);
        lFUCache.put(0,0);
        System.out.println(lFUCache.get(0));
    }
}