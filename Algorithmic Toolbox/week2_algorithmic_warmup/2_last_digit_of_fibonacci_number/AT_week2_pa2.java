import java.util.Scanner;

public class AT_week2_pa2 {
    private static int getFibonacciLastDigit(int n) {
        if(n<=1){
            return n;
        }
        else{
            int[] F = new int[n+1];
            F[0]=0;
            F[1]=1;

            for(int i=2; i<=n;i++){
                F[i]=(F[i-1]+F[i-2])%10;
            }
            return F[n];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigit(n);
        System.out.println(c);
    }
}
