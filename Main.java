import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] brr = new int[m];
        for(int i=0; i<m; i++){
            brr[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i=0; i<m; i++){
            if(freq.containsKey(brr[i])){
                freq.put(brr[i], freq.get(brr[i])+1);
            }else{
                freq.put(brr[i], 1);
            }
        }
        for(int i=0; i<n; i++){
            if(freq.containsKey(arr[i])){
                freq.put(arr[i], freq.get(arr[i])-1);
            }
        }
        for(Map.Entry<Integer, Integer> val:freq.entrySet()){
            if(val.getValue()>0){
                System.out.println(val.getKey()+" ");
            }
        }
        sc.close();
    }
}
