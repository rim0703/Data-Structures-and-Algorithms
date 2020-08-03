import java.util.Scanner;

public class AT_week2_pa1 {
    private static int calc_fib(int n) {
        if(n<=1){
            return n;
        }
        else{
            int[] F = new int[n+1];
            F[0]=0;
            F[1]=1;

            for(int i=2; i<=n;i++){
                F[i]=F[i-1]+F[i-2];
            }
            return F[n];
        }

    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
    }
}
