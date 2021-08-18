package io.been;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> minheap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {
        minheap.add(num);
        maxHeap.add(minheap.peek());
        minheap.poll();
        if (minheap.size() < maxHeap.size()) {
            minheap.add(maxHeap.peek());
            maxHeap.poll();
        }

    }

    public double findMedian() {
        if (minheap.size() == maxHeap.size()) {
            return (minheap.peek() + maxHeap.peek()) / 2.0;
        }
        return minheap.peek();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(2);
        pq.add(1);
        System.out.println(pq.peek());
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        maxpq.add(2);
        maxpq.add(3);
        System.out.println(maxpq.peek());
    }
}
