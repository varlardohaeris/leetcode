package io.been;


import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class Leetcode133 {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node origin = queue.remove();
            Node cur = new Node(origin.val);
            map.put(origin, cur);
            for (int i = 0; i < origin.neighbors.size(); i++) {
                Node nei = origin.neighbors.get(i);
                if (!map.containsKey(nei)) {
                    map.put(nei, null);
                    queue.add(nei);
                }
            }
        }
        for (Map.Entry<Node, Node> e : map.entrySet()) {
            List<Node> oriNeis = e.getKey().neighbors;
            List<Node> copyNeis = e.getValue().neighbors;
            for (int i = 0; i < oriNeis.size(); i++) {
                copyNeis.add(map.get(oriNeis.get(i)));
            }
        }
        return map.get(node);
    }
}
