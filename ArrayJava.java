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
        System.out.println(Arrays.toString(sort(arr)));
        System.out.println("Odd elements are: ");
        System.out.println(printOdd(arr));
        sc.close();
    }
    static int[] sort(int[] arr){
        int n = arr.length;
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
        return arr;
    }
    static int printOdd(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2!=0){
                System.out.print(arr[i]+" ");
                sum += arr[i];
            }
        }
        System.out.println();
        return sum;
    }
    
}
