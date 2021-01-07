import java.io.*;
import java.util.*;

public class pa3_ImprovingQuickSort {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
        //write your code here
        int lessThan = l; // less than the pivot
        int i = l; // scan from left to right
        int greaterThan = r; // greater than the pivot
        int pivot = a[l];
        int[] m = new int[2];
        while(i <= greaterThan){
            if(a[i]<pivot){
                //swap
                int temp = a[lessThan];
                a[lessThan] = a[i];
                a[i] = temp;
                lessThan++;
                i++;
            }
            else if(a[i]>pivot){
                //swap
                int temp = a[greaterThan];
                a[greaterThan] = a[i];
                a[i] = temp;
                greaterThan--;
            }
            else {
                i++;
            }
        }
        m[0]=lessThan;
        m[1]=greaterThan;

        return m;
    }


    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int[] m = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0]-1);
        randomizedQuickSort(a, m[1]+1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}