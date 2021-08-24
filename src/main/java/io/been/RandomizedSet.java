package io.been;

import java.util.*;

public class RandomizedSet {
    private List<Integer> data;
    private Map<Integer, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        data = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        data.add(val);
        map.put(val, data.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int n = data.size();
        int idx = map.get(val);
        int temp = data.get(n - 1);
        data.set(idx, temp);
        data.remove(n - 1);
        map.put(temp, idx);
        map.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random rand = new Random();
        return data.get(rand.nextInt(data.size()));
    }

}
