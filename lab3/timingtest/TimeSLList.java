package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> nValues = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> ops = new AList<>();

        for (int n = 1000; n <= 128000; n*=2) {
            //Blank Alist to test the addLast method
            SLList<Integer> tester = new SLList<>();
            for (int j = 0; j < n; j++) {
                tester.addFirst(j);
            }
            //Timing the addLast for n time
            Stopwatch sw1 = new Stopwatch();
            for (int j = 0; j < 10000; j++) {
                tester.getLast();
            }
            double timeInSeconds = sw1.elapsedTime();

            //Add results to ALists
            nValues.addLast(n);
            times.addLast(timeInSeconds);
            ops.addLast(10000);
        }
        printTimingTable(nValues, times, ops);
    }
}
