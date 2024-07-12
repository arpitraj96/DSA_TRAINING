import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3, 5};
        int[] arr1 = {1, 1, 1, 1, 1, 0, 0, 0, 0, 0};
        selectionSort(arr);
        insertionSort(arr1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }
    static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int m = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[m]>arr[j]){
                    m=j;
                    System.out.println("Swapped at index"+m);
                }
            }
            int temp = arr[i];
            arr[i] = arr[m];
            arr[m] = temp;
        }
    }
    static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int k=arr[i];
            int j = i-1;
            while (j>=0 && arr[j]>k) {  
                arr[j+1] = arr[j];
                j-=1;                
            }
            arr[j+1] = k;
        }
    }
}
