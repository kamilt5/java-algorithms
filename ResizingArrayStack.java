import java.util.Iterator;
import java.lang.Iterable;

public class ResizingArrayStack<Item> implements Iterable<Item> {

    private int N = 0;
    private Item[] a = (Item[]) new Object[1];

    public int size() { return N; }
    public boolean isEmpty() { return N == 0; }

    private void resize(int n) {
        Item[] temp = (Item[]) new Object[n];
        for (int x = 0; x < a.length; x++) {
            temp[x] = a[x];
        }
        a = temp;
    }

    public void push(Item a) {
        if (N >= this.a.length) {
            resize(this.a.length*2);
        } 
        this.a[N++] = a;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N <= a.length/4) {
            resize(a.length/2);
        }
        return item;
    }

    public Iterator<Item> iterator() {
        return new ResizingArrayIterator();
    }

    private class ResizingArrayIterator implements Iterator<Item> {
        private int i = N;
        public boolean hasNext() { return i > 0; }
        public Item next() { return a[i--]; }
        public void remove() { }
    }
}