package io.been;

import java.util.*;

public class Leetcode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        int level = 1;
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.remove();
                char[] chars = cur.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char temp = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String s = new String(chars);
                        if (s.equals(endWord)) return level + 1;
                        if (wordSet.contains(s)) {
                            queue.add(s);
                            wordSet.remove(s);
                        }
                    }
                    chars[i] = temp;
                }
            }
            level++;
        }
        return 0;
    }

}
