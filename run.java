import algorithm.*;
import java.lang.Comparable;
import stopwatch.*;
import java.util.Random;

public class run {
    public static double time(String alg, Comparable[] a) {
        Sort algo;
        Stopwatch watch = new Stopwatch();
        if (alg == "InsertionSort") { algo = new InsertionSort(); algo.sort(a);}
        if (alg == "SelectionSort") { algo = new SelectionSort(); algo.sort(a);}
        if (alg == "ShellSort") { algo = new ShellSort(); algo.sort(a);}

        return watch.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        Random r = new Random(15);
        for (int t = 0; t < T; t++) {
            for( int i = 0; i < a.length; i++)
                a[i] = r.nextDouble();
            total += time(alg, a);
        }
        return total;
    }
    public static void main(String[] args) {
        int N = 100000;
        int T = 1;
        double total1 = timeRandomInput("InsertionSort", N, T);
        double total2 = timeRandomInput("ShellSort", N, T);
        System.out.println("Time for Insertion Sort: " + total1 + " s");
        System.out.println("Time for Shell Sort: " + total2 + " s");
        System.out.printf("Insertion is %.1f times faster", total2/total1);

    }
}
