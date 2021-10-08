package io.been.offer;

import java.util.Stack;

public class Offer30 {
    class MinStack {
        private Stack<Integer> data;
        private Stack<Integer> min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            data = new Stack<>();
            min = new Stack<>();
        }

        public void push(int x) {
            data.push(x);
            if (min.isEmpty()) {
                min.push(x);
            } else {
                if (min.peek() >= x) {
                    min.push(x);
                } else {
                    min.push(min.peek());
                }
            }
        }

        public void pop() {
            min.pop();
            data.pop();
        }

        public int top() {
            return data.peek();
        }

        public int min() {
            return min.peek();
        }
    }
}
