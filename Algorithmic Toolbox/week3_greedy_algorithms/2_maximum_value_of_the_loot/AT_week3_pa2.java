import java.util.Scanner;

public class AT_week3_pa2 {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here
        int cap = 0;
        int total_weight=0;
        double[] ave_value = new double[values.length];
        for(int i=0;i<values.length;i++){
            ave_value[i]=((double)values[i]/(double)weights[i]);
            total_weight+=weights[i];
        }

        while(cap<capacity&&cap<total_weight){
            double max = ave_value[0];
            int cur_value = 0;
            int cur_weight = 0;
            int pos=0;
            for(int i=0;i<values.length;i++){
                if(ave_value[i]>=max){
                    max=ave_value[i];
                    cur_value=values[i];
                    cur_weight=weights[i];
                    pos=i;
                }
            }
            ave_value[pos]=0;
            if(cur_weight<=(capacity-cap)){
                value+=cur_value;
                cap+=cur_weight;
                //System.out.println("cur value: "+value+"cur weight"+cur_weight);
            }
            else {
                double ave = (double)cur_value/(double)cur_weight;
                value+=ave*(capacity-cap);
                cap+=(capacity-cap);
            }
        }
        return (value);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.printf("%.4f",getOptimalValue(capacity, values, weights));
    }
}
