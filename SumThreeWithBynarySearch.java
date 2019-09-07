import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

//O(N^2Log(N))
public class SumThreeWithBynarySearch {

    public static int countSumOfZero(long[] a) {
        long key;
        int k;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                key = 0 - a[j] - a[i];
                k = bynarySearch(a, key);
                if (k != -1) {
                    if (a[i] < a[j] && a[j] < a[k]) {
                        count += 1;
                        //StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                    }
                }
            }
        }
        return count;
    }

    public static int bynarySearch(long[] a, long key) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1; //key in the left part
            else if (key > a[mid]) lo = mid + 1; //key in the right part
            else return mid;
        }
        return -1; //key is not in a
    }


    public static void countFromFile(String filename) {
        In in = new In(filename);
        long[] a = in.readAllLongs();
        Stopwatch timer = new Stopwatch();
        Arrays.sort(a);
        StdOut.println(countSumOfZero(a));
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }

    public static void main(String[] args) {
        String filename = args[0];
        countFromFile(filename);
    }
}
