import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns: ");
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] matrix = new int[row][col]; 
        for(int i=0; i<row; i++){
            for (int j = 0; j < col; j++) {
                System.out.print("Enter the value at index "+i+j+": ");
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        sc.close();
    }
}