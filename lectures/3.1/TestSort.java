/*Import statements to get rid of "org.junit.Test" and just let us use @Test parts of each junit test
    Second import lets us get rid of "org.junit.Assert" in every test function
 */
import org.junit.Test;
import static org.junit.Assert.*;


/* Tests the Sort class. */
public class TestSort {
    //Test the Sort.sort method
    @Test //This tracer allows us to avoid a main function and then have to comment/uncomment tests
    public void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};

        Sort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testFindSmallest() {
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;

        int actual = Sort.findSmallest(input, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        int a = 0;
        int b = 2;
        String[] expected = {"an", "have", "i", "egg"};

        Sort.swap(input, a, b);
        assertArrayEquals(expected, input);
    }
}