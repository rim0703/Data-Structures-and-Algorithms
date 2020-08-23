import java.util.Scanner;

public class AT_week3_pa1 {

    private static int getChange(int m) {
        //write your code here
        int count = 0;
        count=count+(m/10);
        m=m%10;
        count=count+(m/5);
        m=m%5;
        count=count+(m);

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }

}