package deque;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import javax.lang.model.type.ArrayType;

import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void addIsEmptySizeTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);

        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {

        ArrayDeque<String>  lld1 = new ArrayDeque<>();
        ArrayDeque<Double>  lld2 = new ArrayDeque<>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

    }

    @Test
    /* Add a small number of elements and then remove those elements; check resizing operation */
    public void smallArrayDequeTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        for (int i = 0; i < 64; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 32; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 63; i > 32; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }
    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }
    }

    @Test
    /* Test remove first on empty deque and non empty deque*/
    public void removeFirstTest() {
        ArrayDeque<Integer> test1 = new ArrayDeque<>();
        Integer actual = test1.removeFirst();
        assertEquals(null, actual);
    }

    @Test
    /* Test get functions */
    public void getTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            lld1.addLast(i);
        }
        int actual1 = lld1.get(6);
        int actualR1 = lld1.get(4);
        assertEquals(6, actual1);
        assertEquals(4, actualR1);

        Integer actual2 = lld1.get(10);
        Integer actualR2 = lld1.get(10);
        assertEquals(null, actual2);
        assertEquals(null, actualR2);
    }

    @Test
    public void testThreeAddThreeRemove() {
        ArrayDeque<Integer> a1 = new ArrayDeque<>();
        LinkedListDeque<Integer> a2 = new LinkedListDeque<>();

        for (int i=0;i<3;i++) {
            a1.addLast(i);
            a2.addLast(i);
        }

        int i1 = a1.removeLast();
        int i2 = a2.removeLast();
        assertEquals(i1, i2);

        i1 = a1.removeLast();
        i2 = a2.removeLast();
        assertEquals(i1, i2);

        i1 = a1.removeLast();
        i2 = a2.removeLast();
        assertEquals(i1, i2);
    }

    @Test
    public void randomizedTest() {
        ArrayDeque<Integer> Array = new ArrayDeque<>();
        LinkedListDeque<Integer> Link = new LinkedListDeque<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 5);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                Array.addLast(randVal);
                Link.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int sizeCorrect = Array.size();
                int sizeBroken = Link.size();
                assertEquals(sizeCorrect, sizeBroken);
            } else if (operationNumber == 2) {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                Array.addFirst(randVal);
                Link.addFirst(randVal);
            } else if (Array.size() > 0 && Link.size() > 0 && operationNumber == 3) {
                // removeLast
                int lastArray = Array.removeLast();
                int lastLink = Link.removeLast();
                assertEquals(lastArray, lastLink);
            } else if (Array.size() > 0 && Link.size() > 0 && operationNumber == 4) {
                // removeFirst
                int firstArray = Array.removeFirst();
                int firstLink = Link.removeFirst();
                assertEquals(firstArray, firstLink);
            }
        }
    }
}
