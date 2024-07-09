import java.util.Scanner;
import java.util.ArrayList;

public class TimeComplexity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.print("Enter a number: ");
        // int num = sc.nextInt();
        // int sum = 0;
        // while (num>0) {                          //O(log N);
        //     int dig = num%10;
        //     sum += dig;
        //     num /= 10;               //Dividing the num hence it is function of log;
        // }
        // System.out.println(sum);
        System.out.println("Enter a number from which you want to search ");
        System.out.println(primeInRange(17));
        sc.close();
    }
    static boolean prime(int num){
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    static ArrayList<Integer> primeInRange(int num){
        ArrayList<Integer> PrimeInRange = new ArrayList<Integer>();
        while(num>0){
            if(prime(num)){
                PrimeInRange.add(0, num);
            }
            num--;
        }
        return PrimeInRange;
    }
}