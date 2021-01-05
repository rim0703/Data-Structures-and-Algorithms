import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        Arrays.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if(Integer.valueOf(o1.substring(0,1).compareTo(o2.substring(0,1)))==0){
                    if(o1.length()>o2.length()||o1.length()==o2.length()){
                        if(Integer.valueOf(o1.substring(o1.length()-1))>Integer.valueOf(o2.substring(o2.length()-1))){
                            System.out.println(o1+" "+o2);
                            return Integer.valueOf(o2).compareTo(Integer.valueOf(o1));
                        }else{
                            return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));
                        }

                    }else{
                        return Integer.valueOf(o2).compareTo(Integer.valueOf(o1));
                    }
                }

                /*
                if(o1.length()<o2.length()){
                    return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));
                }*/
                return Integer.valueOf(o2).compareTo(Integer.valueOf(o1));
            }
        });


        String result = "";
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

