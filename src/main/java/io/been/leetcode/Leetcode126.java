package io.been.leetcode;

import java.util.*;

public class Leetcode126 {
    public List<List<String>> findLadders(String beginWord, String endWord,
                                          List<String> wordList) {
        Set<String> dict = new HashSet<>();
        dict.addAll(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!dict.contains(endWord)) {
            return res;
        }
        Set<String> visited = new HashSet<>();
        List<Node> ends = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(beginWord, null));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.remove();
                String w = cur.word;
                visited.add(w);
                if (w.equals(endWord)) {
                    ends.add(cur);
                }
                StringBuilder next = new StringBuilder(w);
                for (int j = 0; j < w.length(); j++) {
                    char c = w.charAt(j);
                    for (int k = 0; k < 26; k++) {
                        char r = (char) ('a' + k);
                        if (r == c) {
                            continue;
                        }
                        next.setCharAt(j, r);
                        String ns = next.toString();
                        if (dict.contains(ns) && !visited.contains(ns)) {
                            queue.add(new Node(ns, cur));
                        }
                    }
                    next.setCharAt(j, c);
                }
            }
            if (ends.size() > 0) {
                break;
            }
        }
        for (Node end : ends) {
            res.add(getPath(end));
        }
        return res;
    }

    public List<String> getPath(Node end) {
        Deque<String> path = new ArrayDeque<>();
        while (end != null) {
            path.addFirst(end.word);
            end = end.prev;
        }
        return new ArrayList<>(path);
    }

    class Node {
        String word;
        Node prev;

        public Node(String word, Node prev) {
            this.word = word;
            this.prev = prev;
        }
    }
}
