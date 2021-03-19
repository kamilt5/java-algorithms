package stringsorting;

import java.lang.Math;

class InsertionSort {
    public static void sort(String[] s, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(s[j], s[j-1], d); j--)
                exchange(s, j, j-1);
    }

    private static boolean less(String v, String w, int d) {
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) return true;
            else if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }

    private static void exchange(String[] a, int i, int j) {
        String temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
}

public class MSD {
    private static int R = 256;
    private static final int M = 15;
    private static String[] aux;

    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d); else return -1;
    }

    public static void sort(String[] s) {
        int N = s.length;
        aux = new String[N];
        sort(s, 0, N-1, 0);
    }

    private static void sort(String[] s, int lo, int hi, int d) {
        if (hi <= lo + M) {
            InsertionSort.sort(s, lo, hi, d);
            return; 
        }
        int[] count = new int[R+2];

        for (int i = lo; i <= hi; i++)
            count[charAt(s[i], d) + 2]++;

        for (int r = 0; r < R+1; r++)
            count[r+1] += count[r];

        for (int i = lo; i <= hi; i++)
            aux[count[charAt(s[i], d) + 1]++] = s[i];

        for (int i = 0; i <= hi; i++)
            s[i] = aux[i-lo];

        for (int r = 0; r < R; r++)
            sort(s, lo + count[r], lo + count[r+1] - 1, d+1);
    }
}
//?????????????????????????????????????????????????????????????????????????????????????????
// co to kurwa jest ?????????????????????????????????????????????????????//
// ja pierdole
// jebac
// kurwa nie rozumiem
