package symboltable;

import java.lang.Comparable;

public class SymbolTable<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public SymbolTable(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0)
            return vals[i];
        else
            return null;
    }
    
    public void put(Key key, Value val) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    private int rank(Key key) {
        int lo = 0;
        int hi = N-1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (key.compareTo(keys[mid]) < 0)
                hi = mid;
            else 
                lo = mid + 1;
        }
        return lo;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void delete(Key key) {
        put(key, null);
    }

    public void deleteMin() {
        //delete(min());                               //TODO
    }

    public void deleteMax() {
        //delete(max());                                //TODO
    }

    public int size(Key lo, Key hi) {
        if (hi.compareTo(lo) < 0) return 0;
        else if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else return rank(hi) - rank(lo);
    }

    public int size() {
        return N;
    }


}
