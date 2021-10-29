package randomizedtest;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> a1 = new AListNoResizing<>();
        BuggyAList<Integer> a2 = new BuggyAList<>();

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
        AListNoResizing<Integer> Correct = new AListNoResizing<>();
        BuggyAList<Integer> Broken = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                Correct.addLast(randVal);
                Broken.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int sizeCorrect = Correct.size();
                int sizeBroken = Broken.size();
                assertEquals(sizeCorrect, sizeBroken);
            } else if (Correct.size() > 0 && operationNumber == 2) {
                // getLast
                int lastCorrect = Correct.getLast();
                int lastBroken = Broken.getLast();
                assertEquals(lastCorrect, lastBroken);
            } else if (Correct.size() > 0 && operationNumber == 3) {
                // removeLast
                int lastCorrect = Correct.removeLast();
                int lastBroken = Broken.removeLast();
                assertEquals(lastCorrect, lastBroken);
            }
        }
    }
}
