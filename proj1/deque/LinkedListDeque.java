package deque;

public class LinkedListDeque<Item> {
    private class Node<Item> {
        public Item item;
        public Node next;

        public Node(Item i, Node n) {
            item = i;
            next = n;
        }
    }

    private Node<Item> sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null);
        size = 0;
    }

    public LinkedListDeque(Item i) {
        sentinel = new Node(i, null);
        size = 1;
    }

    public void addFirst(Item i) {
        sentinel = new Node(i, sentinel);
        size++;
    }

    public void addLast()
}
