package LinkedList;

public class LinkedList <Item> {
    private int N = 0;
    private Node first;

    private class Node {
        Item item;
        Node next;
    }

    public int size() { return N; }
    public boolean isEmpty() { return N == 0 && first == null; }

    public void push(Item it) {
        Node temp = first;
        Node node = new Node();
        node.item = it;
        first = node;
        first.next = temp;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
}
