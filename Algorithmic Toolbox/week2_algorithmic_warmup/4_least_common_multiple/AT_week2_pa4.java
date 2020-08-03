import java.util.Scanner;

public class AT_week2_pa4 {
    private static long lcm(int a, int b) {
        if(a<b){
            int temp = b;
            b=a;
            a=temp;
        }
        if(b==0){
            return a;
        }
        int new_a = a%b;
        return lcm(b,new_a);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        long result = lcm(a,b);

        System.out.print((long)a*b/result);
    }
}
