public class Sort {
    public static void sort(String[] x) {
        // Selection sort:
        // Find smallest
        // Put smallest in the beginning
        // Sort through the rest of the list... recursion?
        sort(x, 0);
    }

    //Private sort method that sorts x starting at position start
    private static void sort(String[] x, int start) {
        if (start == x.length) {
            return;
        }
        int smallestIndex = findSmallest(x, start);
        swap(x, start, smallestIndex);
        sort(x, start + 1);
    }

    /* Returns the smallest string in x. */
    public static int findSmallest(String[] x, int start) {
        int smallestIndex = start;
        for (int i = start; i < x.length; i++) {
            int cmp = x[i].compareTo(x[smallestIndex]);
            if (cmp < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    /*Swaps item a with b */
    public static void swap(String[] x, int a, int b) {
        String tmp = x[a];
        x[a] = x[b];
        x[b] = tmp;
    }
}
