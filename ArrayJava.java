import java.util.Arrays;
import java.util.Scanner;

public class ArrayJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        int sum = 0;
        for(int i=0; i<size; i++){
            System.out.print("Enter the element at index "+(i+1)+": ");
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        System.out.println("The sum of the elements are: "+sum);
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
}
