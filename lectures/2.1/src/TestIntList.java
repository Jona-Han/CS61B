import org.junit.Test;
import static org.junit.Assert.*;

public class TestIntList {

    @Test
    public void TestSize() {
       IntList L = new IntList(15, null);
       L = new IntList(10, L);
       L = new IntList(5, L);
       L = new IntList(4, L);
       L = new IntList(3, L);

       int expected = 5;
       int actual = L.size();

       assertEquals(actual, expected);
    }

    @Test
    public void TestIterativeSize() {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        L = new IntList(4, L);
        L = new IntList(3, L);

        int expected = 5;
        int actual = L.iterativeSize();

        assertEquals(actual, expected);
    }

    @Test
    public void TestGet() {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        L = new IntList(4, L);
        L = new IntList(3, L);

        int expected = 5;
        int actual = L.get(2);
        assertEquals(actual, expected);

        int expected2 = 3;
        int actual2 = L.get(0);
        assertEquals(actual2, expected2);

        int expected3 = 15;
        int actual3 = L.get(4);
        assertEquals(actual3, expected3);
    }
}