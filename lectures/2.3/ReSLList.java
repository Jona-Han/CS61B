public class ReSLList {
    private static class IntNode {
        int item;
        IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    public ReSLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public ReSLList(int i) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(i, null);
        size = 1;
    }

    public void addFirst(int i) {
        sentinel.next = new IntNode(i, sentinel.next);
        size++;
    }

    public int getFirst(int i) {
        return sentinel.next.item;
    }

    public int addLast(int i) {
        IntNode p = sentinel;
        while (p.next != null) {
           p = p.next;
        }
        p.next = new IntNode(i, null);
        size++;
    }

    public int size() {
        return size;
    }

}