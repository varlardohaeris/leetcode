package io.been.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        StringBuilder builder = new StringBuilder();
        builder.append(root.val)
                .append(",").append(serialize(root.left))
                .append(",").append(serialize(root.right));
        return builder.toString();
    }

    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if (arr.length == 0) return null;
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, arr);
        return des(queue);
    }

    private TreeNode des(Queue<String> queue) {
        if (queue.size() == 0) return null;
        String cur = queue.poll();
        if ("#".equals(cur)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = des(queue);
        root.right = des(queue);
        return root;
    }
}
