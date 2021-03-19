package queue;

import java.lang.Comparable;

public class PriorityQueue<Key extends Comparable<Key>>  {
    private Key[] pq;
    private int N = 0;

    public PriorityQueue(int maxN) {
        pq = (Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key i) {
        pq[++N] = i;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exchange(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    private void swim(int i) {
        while (i > 1 && less(i/2, i)) {
            exchange(i, i/2);
            i = i/2;
        }
    }

    private void sink(int i) {
        while (i*2 <= N) {
            int j = i * 2;
            if (j < N && less(j, j+1)) j++;
            if (!less(i, j)) break;
            exchange(i, j);
            i = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exchange(int i, int j) {
        Key temp = pq[i]; pq[i] = pq[j]; pq[j] = temp;
    }
}
