/*An SLList is a list of integers, which hides the terribl truth of the nakedness within.
* Our programmer who uses an SLList will not have to think about recursion or how IntNode works
* */

public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    /*The first item if it exists is at sentinel.next. */

    //Constructor for empty list
    public SLList() {
        sentinel = new IntNode(63, null); //63 is arbitrary since the first sentinel node's item doesn't matter
        size = 0;
    }
    public SLList (int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public SLList(int[] x) {
        sentinel = new IntNode(63, null);
        for (int value : x) {
            addLast(value);
        }
    }

    //Adds x to the front of the list
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    //Returns the first item in the list
    public int getFirst() {
        return sentinel.next.item;
    }

    //Adds x to the end of the list
    public void addLast(int x) {
        IntNode p = sentinel;

        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
        size += 1;
    }

    public void deleteFirst() {
        if (size <= 1) {
            sentinel.next = null;
            size = 0;
        } else {
            sentinel.next = sentinel.next.next;
            size -= 1;
        }
    }
    /*Inefficient size method
      Private static because it interacts with the naked IntList class

    private static int size(IntNode p) {
        if (p.next == null) {
            return 1;
        }
        return 1 + size(p.next);
    }

    Gets size of SLList
    public facing function to get size

    public int size() {
        return size(first);
    }
    */

    //More efficient size method using a size counter attribute
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        int[] ints = {5, 10, 7};
        SLList L = new SLList(ints);
        System.out.println(L.size());
    }
}
