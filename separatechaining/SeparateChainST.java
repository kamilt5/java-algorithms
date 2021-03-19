package separatechaining;

import sequencialsearch.SequentialSearch;

public class SeparateChainST<Key, Value> {
    
    private SequentialSearch<Key, Value>[] st;
    private int N;

    public SeparateChainST() {
        this(997);
    }

    public SeparateChainST(int N) {
        st = (SequentialSearch<Key, Value>[]) new SequentialSearch[N]; 
        this.N = N;
        for (int i = 0; i < N; i++) {
            st[i] = new SequentialSearch();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % N;
    }

    public Value get(Key key) {
        return (Value) st[hash(key)].get(key);
    }

    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
    }

    //public Iterable<Key> keys();               TODO

}
