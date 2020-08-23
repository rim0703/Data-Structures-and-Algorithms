import java.util.Scanner;

public class AT_week3_pa3 {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int numRefills = 0;
        int currentPos = 0;
        int lastPos = 0;
        int[] fuel = new int [stops.length+2];
        fuel[0]=0;
        fuel[stops.length+1]=dist;
        for(int i=0;i<stops.length;i++){
            fuel[i+1]=stops[i];
        }
        if(dist<tank){
            return 0;
        }
        if(dist-fuel[stops.length]>tank){
            return -1;
        }
        while(currentPos<fuel.length-1){
            lastPos = currentPos;
            while(fuel[currentPos+1]-fuel[lastPos]<=tank){
                currentPos=currentPos+1;
                if(currentPos+1==(fuel.length)){
                    break;
                }
            }
            if(currentPos==lastPos){
                return -1;
            }
            if(currentPos<=fuel.length){
                numRefills=numRefills+1;
                //System.out.println(currentPos+" "+lastPos+" ");
            }
        }
        numRefills--;

        return numRefills;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));

    }
}
