package algorithm;

import java.util.Collections;
import algorithm.Sort;
import algorithm.InsertionSort;

public class QuickSort implements Sort {
    
    private InsertionSort insort = new InsertionSort();
    private int M;

    public QuickSort() {
        M = 10;
    }

    public QuickSort(int size) {
        M = size;
    }

    public void sort(Comparable[] a) {
        //Collections.shuffle(a);                  <---------------------------------------------------------------------TODO
        sort(a, 0, a.length - 1);
    }

    public void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo + M) {
            insort.sort(a, lo, hi);
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }
}

public class Quick3way
{
    private static void sort(Comparable[] a, int lo, int hi){ 
    // See page 289 for public sort() that calls this method.
        if (hi <= lo) return;
        int lt = lo, i = lo+1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt){
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        } // Now a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
}
}
