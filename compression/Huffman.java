package compression;

import java.lang.Comparable;
import queue.PriorityQueue;

public class Huffman {
    private static class Node implements Comparable<Node> {
        private char ch;
        private int freq;
        private final Node left, right;

        public Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            return this.freq - o.freq;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }
    }

    private static String[] buildCode(Node root) {
        String[] st = new String[R];
        buildCode(st, root, "");
        return st;
    }

    private static void buildCode(String[] st, Node x, String s) {
        if (x.isLeaf()) {
            st[x.ch] = s;
            return;
        }
        buildCode(st, x.left, s + "0");
        buildCode(st, x.right, s + "1");
    }

    private static String compress(String input, String[] st) {
        String comp = "";
        for (int i = 0; i < input.length(); i++) {
            comp += st[input.charAt(i)];
        }
        return comp;
    }

    private static Node buildTrie(int[] freq) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
    }
}
