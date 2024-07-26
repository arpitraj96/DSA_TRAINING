package VJudge;

import java.util.Scanner;
public class TriangleValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        if (isValidTriangle(A, B, C)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        sc.close();
    }
    public static boolean isValidTriangle(int A, int B, int C) {
        return (A + B > C) && (A + C > B) && (B + C > A);
    }
}

