package algorithm;

import java.lang.Comparable;

public interface Sort{
    default void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    default boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }

    public void sort(Comparable[] a);


    default boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; ++i) {
            if(less(a[i-1], a[i])) return false;
        }
        return true;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; ++i)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}
