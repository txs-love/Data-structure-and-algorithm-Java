package org.LeetCode;

/**
 * 页面置换算法LRU  1.双向链表 + HashMap
 *                2. 队列 + 哈希表

 */
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put(1,1);
        lruCache.put(2,3);
        lruCache.put(4,1);
        lruCache.put(3,1);
        lruCache.put(7,1);
    }
    private int capacity;
    private Map<Integer, Integer> map;
    private LinkedList<Integer> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.list = new LinkedList<>();
    }

    public int get(int key) {      //如果capacity已经满了的情况下面;
        if (!map.containsKey(key)) {
            return -1;
        }

        // Move the accessed key to the front of the list
        list.remove((Integer) key);
        list.addFirst(key);

        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update the value and move the key to the front of the list
            map.put(key, value);
            list.remove((Integer) key);
            list.addFirst(key);
        } else {
            if (map.size() == capacity) {
                // Remove the least recently used key from the map and the list
                map.remove(list.removeLast());
            }

            // Add the new key to the map and the front of the list
            map.put(key, value);
            list.addFirst(key);
        }
    }
}

