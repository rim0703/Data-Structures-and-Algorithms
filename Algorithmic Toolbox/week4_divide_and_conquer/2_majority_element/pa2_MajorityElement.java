import java.util.*;
import java.io.*;

public class pa2_MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        //write your code here
        /*
        int contain = a.length / 2;
        int count = 1;
        Arrays.sort(a);
        for(int i=0;i<a.length-1;i++){
            if(a[i]==a[i+1]){
                count++;
                //System.out.println(count+"num: "+a[i]);
                if(count>contain){
                    return 0;
                }
            }
        }
        return -1;*/
        int left_elem = getMajorityElement(a, left, (left + right - 1) / 2 + 1);
        int right_elem = getMajorityElement(a, (left + right - 1) / 2 + 1, right);

        int lcount = 0;
        for (int i = left; i < right; i++) {
            if (a[i] == left_elem)
                lcount += 1;
        }
        if (lcount > (right - left) / 2)
            return left_elem;

        int rcount = 0;
        for (int i = left; i < right; i++) {
            if (a[i] == right_elem)
                rcount += 1;
        }
        if (rcount > (right - left) / 2)
            return right_elem;
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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
