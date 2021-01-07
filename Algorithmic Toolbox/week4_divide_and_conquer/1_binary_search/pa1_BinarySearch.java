import java.io.*;
import java.util.*;

public class pa1_BinarySearch {

    static int binarySearch(int[] a, int x) {
        int left = 0, right = a.length;
        //write your code here
        int pos = 0;
        int mid = a.length/2;
        if(a[mid]==x){
            return mid;
        }
        while(a[mid]<x) {
            if(mid==a.length-1){
                // not found
                pos=-1;
                break;
            }
            left=mid;
            mid = (left+right)/2;
            if(mid == left){
                //not found
                pos=-1;
                break;
            }
            while(a[mid]>x){
                right=mid;
                mid = (left+right)/2;
                if(mid == right){
                    //not found
                    pos = 1;
                    break;
                }
            }
            if(a[mid]==x){
                pos = mid;
                break;
            }
        }
        while(a[mid]>x){
            if(mid==a.length-1 || mid == 0){
                pos = -1;
                break;
            }
            right=mid;
            mid=(left+right)/2;
            if(mid==right){
                //not found
                pos=-1;
                break;
            }
            while(a[mid]<x){
                left=mid;
                mid=(left+right)/2;
                if(mid==left){
                    //not found
                    pos=-1;
                    break;
                }
            }
            if(a[mid]==x){
                pos = mid;
                break;
            }
        }

        return pos;
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearch(a, b[i]) + " ");
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

