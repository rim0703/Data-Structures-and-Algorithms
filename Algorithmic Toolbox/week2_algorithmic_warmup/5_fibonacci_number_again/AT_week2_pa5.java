import java.math.BigInteger;
import java.util.Scanner;

public class AT_week2_pa5 {
    public static long getFibonacciHuge(long n,long m ){
        long remainder = n%pisanoPeriod(m);
        long first = 0;
        long second = 1;
        long res = remainder;
        for(int i=1;i<remainder;i++){
            res = (first+second)%m;
            first=second;
            second=res;
        }
        return res%m;
    }
    public static long pisanoPeriod (long m ){
        long a = 0;
        long b = 1;
        long c = a+b;
        for(int i =0;i<m*m;i++){
            c=(a+b)%m;
            a=b;
            b=c;
            if(a==0&&b==1)
                return i+1;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}
