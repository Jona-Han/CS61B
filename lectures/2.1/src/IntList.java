public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    // Return the size of the list using recursion
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    // Return the size of the list using iteration
    public int iterativeSize() {
        IntList currentList = this;
        int count = 1;
        while (currentList.rest != null) {
            count++;
            currentList = currentList.rest;
        }
        return count;
    }

    // Return the ith element of the list
    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i-1);
    }

    /** Returns an IntList identical to L, but with
     * each element incremented by x. L is not allowed
     * to change. */
    public static IntList incrList(IntList L, int x) {
        IntList P = new IntList(L.first + x, null);
        IntList Original = P;

        while (L.rest != null) {
            L = L.rest;
            P.rest = new IntList(L.first + x, null);
            P = P.rest;
        }
        return Original;
    }

    /** Returns an IntList identical to L, but with
     * each element incremented by x. Not allowed to use
     * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        IntList Original = L;
        while (L != null) {
            L.first += x;
            L = L.rest;
        }
        return Original;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);

      //  incrList(L, 3);
        dincrList(L, 3);
    }
}