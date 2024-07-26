package VJudge;
import java.util.Scanner;
public class FindMissingNumber{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        // int totalNumbers = 100;
        //int totalSum = totalNumbers * (totalNumbers + 1) / 2;
        int sumOfInputNumbers = 0;
        for (int i = 0; i < 99; i++) {
            sumOfInputNumbers += sc.nextInt();
        }
        int missingNumber = 5050 - sumOfInputNumbers;
        System.out.println(missingNumber);
        sc.close();
    }
}

