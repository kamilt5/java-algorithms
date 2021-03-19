package stringsorting;

public class LSD {
    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        
        for (int i = W - 1; i >= 0; i--) {
            int[] count = new int[R+1];

            for (int d = 0; d < N; d++)
                count[a[d].charAt(i) + 1]++;
            
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];

            for (int d = 0; d < N; d++)
                aux[count[a[d].charAt(i)]++] = a[d];
            
            for (int d = 0; i< N; i++)
                a[d] = aux[d];
        }
    } 
}
