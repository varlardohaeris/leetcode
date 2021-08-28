package io.been.leetcode;

import java.util.LinkedHashMap;

public class LRUCache {
    private int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        makeRecent(key);
        return cache.get(key);
    }

    private void makeRecent(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecent(key);
            return;
        }
        if (cache.size() >= this.cap) {
            int old = cache.keySet().iterator().next();
            cache.remove(old);
        }
        cache.put(key, value);
    }


}
