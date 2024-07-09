import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns: ");
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] matrix = new int[row][col]; 
        for(int i=0; i<row; i++){
            for (int j = 0; j < col; j++) {
                System.out.print("Enter the value at index "+i+j+": ");
                matrix[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<row; i++){
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println(Arrays.deepToString(matrix));
        for(int i=0; i<row; i++){
            for (int j = 0; j < col; j++) {
                if(i==j){
                    System.out.print(matrix[i][j]);
                    System.out.print(" ");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        diagonalElements(matrix);
        allDiagonalElements(matrix, row, col);
        sc.close();
    }
    static void diagonalElements(int[][] arr){
        System.out.println("Primary Diagonal Elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][i] + " ");
        }
        System.out.println();
        
        System.out.println("Secondary Diagonal Elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][arr.length - 1 - i] + " ");
        }
        System.out.println();
    }
    static void allDiagonalElements(int[][] arr, int rows, int cols){
        for (int diag = 0; diag < rows + cols - 1; diag++) {
            // Determine starting point of the diagonal
            int startRow = Math.min(diag, rows - 1);
            int startCol = Math.max(0, diag - rows + 1);

            // Collect elements in this diagonal
            StringBuilder diagonalElements = new StringBuilder();
            for (int i = startRow, j = startCol; i >= 0 && j < cols; i--, j++) {
                diagonalElements.append(arr[i][j]).append(" ");
            }

            // Print the diagonal elements as a group
            System.out.println("(" + diagonalElements.toString().trim() + ")");
        }
    }
}
