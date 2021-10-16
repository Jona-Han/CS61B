/*An SLList is a list of integers, which hides the terribl truth of the nakedness within.
 * Our programmer who uses an SLList will not have to think about recursion or how StuffNode works
 * */

public class SLList<LochNess> { //<> kind of like C++ templates. Allows us to use types
    private class StuffNode {
        public LochNess item;
        public StuffNode next;
        public StuffNode(LochNess i, StuffNode n) {
            item = i;
            next = n;
        }
    }

    private StuffNode sentinel;
    private int size;

    /*The first item if it exists is at sentinel.next. */

    //Constructor for empty list
    public SLList() {
        sentinel = new StuffNode(null, null);
        size = 0;
    }
    public SLList (LochNess x) {
        sentinel = new StuffNode(null, null);
        sentinel.next = new StuffNode(x, null);
        size = 1;
    }

    //Adds x to the front of the list
    public void addFirst(LochNess x) {
        sentinel.next = new StuffNode(x, sentinel.next);
        size += 1;
    }

    //Returns the first item in the list
    public LochNess getFirst() {
        return sentinel.next.item;
    }

    //Adds x to the end of the list
    public void addLast(LochNess x) {
        StuffNode p = sentinel;

        while (p.next != null) {
            p = p.next;
        }
        p.next = new StuffNode(x, null);
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

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLList L = new SLList(5);
        L.addLast("is");
        L.addFirst("funny");
        System.out.println(L.size());
    }
}
