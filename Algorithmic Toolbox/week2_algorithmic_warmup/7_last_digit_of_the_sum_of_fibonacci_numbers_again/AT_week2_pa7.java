import java.util.Scanner;

public class AT_week2_pa7 {
    private static long getFibonacciPartialSum(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;
        from=from%pisanoPeriod(10);
        to=to%pisanoPeriod(10);
        //System.out.println(from+" "+to);

        if(from>to){
            for (long i = 0; i < 60; i++) {
                if (i >= from) {
                    sum = (sum+current)%10;
                }

                long new_current =next;
                next = (current+next);
                current = new_current;
            }
            //System.out.println(sum) ;
            current=0;
            next=1;
            for(long i=0;i<to;i++){
                long new_current =next;
                next = (current+next);
                current = new_current;
                sum=sum+current;
            }
            //System.out.println(sum) ;
        }


        else{
            for (long i = 0; i <= to; i++) {
                if (i >= from) {
                    sum = (sum+current);
                    //System.out.print(sum+" ");
                }

                long new_current =next;
                next = (current+next);
                current = new_current;
            }
        }
        return sum%10;
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
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}
