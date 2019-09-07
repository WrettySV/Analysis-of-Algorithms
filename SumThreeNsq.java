/* *****************************************************************************
 *  3-SUM in quadratic time.
 * Design an algorithm for the 3-SUM problem that takes time proportional to n^2 in the worst case.
 * You may assume that you can sort the n integers in time proportional to n^2 or better.
 * Hint: given an integer x and a sorted array a[] of n distinct integers,
 * design a linear-time algorithm to determine if there exists two distinct indices i and j
 * such that a[i]+a[j]==x.
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class SumThreeNsq {

    public static int countSumOfZero(long[] a) {
        int count = 0;
        int lo, hi, n = a.length;

        for (int i = 0; i < n; i++) {
            lo = i + 1;
            hi = n - 1;
            while (lo < hi) {
                if (a[i] + a[lo] + a[hi] == 0) {
                    count += 1;
                    //StdOut.println(a[i] + " " + a[lo] + " " + a[hi]);
                    lo += 1;
                    hi -= 1;
                }
                else if (a[i] + a[lo] + a[hi] > 0) hi -= 1;
                else lo += 1;
            }
        }
        return count;
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
