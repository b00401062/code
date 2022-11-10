package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class IsMatch {
    private static class Graph {
        private static class Edge {
            int s;
            int t;
            Character w = null;

            Edge(int s, int t) {
                this.s = s;
                this.t = t;
            }

            Edge(int s, int t, Character w) {
                this.s = s;
                this.t = t;
                this.w = w;
            }
        }

        private static class Node {
            List<Edge> edges = new ArrayList<>();
            boolean visited = false;
        }

        private List<Node> nodes = new ArrayList<>();

        Graph(String p) {
            p = p.replace('?', '.').replace("*", ".*");
            addNode();
            for (var i = 0; i < p.length();) {
                if (i < p.length() - 1 && p.charAt(i + 1) == '*') {
                    var n1 = addNode();
                    var n2 = addNode();
                    var n3 = addNode();
                    var n0 = n1 - 1;
                    addEdge(n0, n1);
                    addEdge(n0, n3);
                    addEdge(n1, n2, p.charAt(i));
                    addEdge(n2, n1);
                    addEdge(n2, n3);
                    i += 2;
                } else {
                    var n1 = addNode();
                    var n0 = n1 - 1;
                    addEdge(n0, n1, p.charAt(i));
                    i++;
                }
            }
        }

        private int addNode() {
            nodes.add(new Node());
            return nodes.size() - 1;
        }

        private void addEdge(int s, int t) {
            nodes.get(s).edges.add(new Edge(s, t));
        }

        private void addEdge(int s, int t, Character w) {
            nodes.get(s).edges.add(new Edge(s, t, w));
        }

        private Set<Integer> bfs(Set<Integer> set){
            for (var node : nodes) {
                node.visited = false;
            }
            var queue = new LinkedList<Integer>(set);
            while (!queue.isEmpty()) {
                var n = queue.removeFirst();
                nodes.get(n).visited = true;
                for (var e : nodes.get(n).edges) {
                    if (e.w == null) {
                        queue.add(e.t);
                    }
                }
            }
            return (
                IntStream
                .range(0, nodes.size())
                .filter((it) -> nodes.get(it).visited)
                .boxed()
                .collect(Collectors.toSet())
            );
        }

        public boolean match(String s) {
            var set = bfs(Set.<Integer>of(0));
            for (var c : s.toCharArray()) {
                var tmpSet = new HashSet<Integer>();
                for (var n : set) {
                    for (var e : nodes.get(n).edges) {
                        if (e.w != null && (e.w == c || e.w == '.')) {
                            tmpSet.add(e.t);
                        }
                    }
                }
                if (tmpSet.isEmpty()) {
                    return false;
                }
                set = bfs(tmpSet);
            }
            return set.contains(nodes.size() - 1);
        }
    }

    public static boolean isMatch(String s, String p) {
        return new Graph(p).match(s);
    }
}
