import java.util.Scanner;

public class AT_week1_pa2 {
    public static long max_product(long[] arr){
        long num_1 = 0;
        long num_2 = 0;
        int pos = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>num_1){
                num_1=arr[i];
                pos = i;
            }
        }
        for(int j=0;j<arr.length;j++){
            if(arr[j]>num_2 && j!=pos){
                num_2=arr[j];
            }
        }


        return num_1*num_2;
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        long[] array = new long[size];
        for(int i=0;i<size;i++){
            array[i]=sc.nextLong();
        }
        System.out.println(max_product(array));
    }
}
