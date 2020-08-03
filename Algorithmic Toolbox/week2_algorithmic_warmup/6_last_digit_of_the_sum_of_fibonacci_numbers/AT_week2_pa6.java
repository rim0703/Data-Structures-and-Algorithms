import java.util.Scanner;

public class AT_week2_pa6 {
    private static long getFibonacciSum(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 0;
        n=n%pisanoPeriod(10);
        if(n!=0){
            sum=1;
        }
        for (long i = 0; i < n-1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum =(sum+current)%10;
            //System.out.print(sum+" ");
        }

        return sum;
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

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();

        System.out.println(getFibonacciSum(n));
    }
}
