package io.been.leetcode;

import java.util.Arrays;
// https://www.bilibili.com/video/BV11t411V7h3?from=search&seid=288925077812544339&spm_id_from=333.337.0.0
public class Leetcode621 {
    public int leastInterval(char[] tasks, int n) {
        int[] record = new int[26];
        for (char task : tasks) {
            record[task - 'A']++;
        }
        Arrays.sort(record);
        int max_n = record[25] - 1;
        int space = max_n * n;
        for (int i = 24; i >= 0 && record[i] > 0; i--) {
            space -= Math.min(max_n, record[i]);
        }
        return space > 0 ? tasks.length + space : tasks.length;
    }
}
