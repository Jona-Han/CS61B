package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> nValues = new AList<>();
        AList<Double> times = new AList<>();

        for (int n = 1000; n <= 128000; n*=2) {
            AList<Integer> tester = new AList<>();
            Stopwatch sw1 = new Stopwatch();
            for (int j = 0; j < n; j++) {
               tester.addLast(j);
            }
            double timeInSeconds = sw1.elapsedTime();
            nValues.addLast(n);
            times.addLast(timeInSeconds);
        }

        printTimingTable(nValues, times, nValues);
    }
}
