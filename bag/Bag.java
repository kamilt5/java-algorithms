package bag;

import java.util.Iterator;
import java.lang.Iterable;

public class Bag<Item> implements Iterable<Item>{
    private int N = 0;
    private Node first;

    private class Node {
        Item item;
        Node next;
    }

    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {  }
    }
}
