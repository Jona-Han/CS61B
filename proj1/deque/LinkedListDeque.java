package deque;

public class LinkedListDeque<Item> implements Deque<Item>{
     private class Node {
        public Item item;
        public Node next;
        public Node previous;

        public Node(Item i, Node n, Node p) {
            item = i;
            next = n;
            previous = p;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, sentinel, sentinel);
        sentinel.next = sentinel;
        sentinel.previous = sentinel;
        size = 0;
    }

    public LinkedListDeque(Item i) {
        sentinel = new Node(null, null, null);
        sentinel.next = new Node(i, sentinel, sentinel);
        sentinel.previous = sentinel.next;
        size = 1;
    }

    @Override
    public void addFirst(Item i) {
        sentinel.next = new Node(i, sentinel.next, sentinel);
        sentinel.next.next.previous = sentinel.next;
        size++;
    }

    @Override
    public void addLast(Item i) {
        sentinel.previous = new Node(i, sentinel, sentinel.previous);
        sentinel.previous.previous.next = sentinel.previous;
        size++;
    }

    @Override
    public int size() {return size;}

    @Override
    public Item removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Item first = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.previous = sentinel;
            size--;
            return first;
        }
    }

    @Override
    public Item removeLast() {
        if (size == 0) {
            return null;
        } else {
            Item last = sentinel.previous.item;
            sentinel.previous = sentinel.previous.previous;
            sentinel.previous.next = sentinel;
            size--;
            return last;
        }
    }

    @Override
    public Item get(int index) {
        if (index >= size) {
            return null;
        } else {
            Node point = sentinel.next;
            for (int counter = 0; counter < index; counter++) {
                point = point.next;
            }
            return point.item;
        }
    }

    @Override
    public void printDeque() {
        for (Node point = sentinel.next; point != sentinel; point = point.next) {
            System.out.print(point.item + " ");
        }
        System.out.println();
    }

    public Item getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursive(index, sentinel.next);
    }

    private Item getRecursive(int index, Node currentNode) {
        if (index == 0) {
            return currentNode.item;
        } else {
            return getRecursive(index - 1, currentNode.next);
        }
    }

}
