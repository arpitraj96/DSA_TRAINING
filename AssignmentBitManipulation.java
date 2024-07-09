import java.util.Scanner;

public class AssignmentBitManipulation {
    // Kth bit set or not
    public static void kthBitSetUnset(int n, int k) {
        int bitMask = 1<<k;

        if ((bitMask & n) == 0) {
            System.out.println("No");
        } else {
            System.out.println("YES");
        }
    }

    // Binary Palindrome
    public static void binaryPalindrome(int n) {
        if (n==0 || n==1) {
            System.out.println("True");
            return;
        }

        StringBuilder bin = new StringBuilder();
        while (n>0) {
            int rem = n%2;
            bin.insert(0, rem);
            n /= 2;
        }
        
        String tempBin = bin.toString();
        String revBin = "";
        for (int i=tempBin.length()-1; i>=0; i--) {
            revBin += tempBin.charAt(i);
        }
        System.out.println(tempBin.equals(revBin));

    }

    public static int bitDifference(int nums[]) {

        int totalBitDifference = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int xor = nums[i]^nums[j];
                totalBitDifference += (Integer.bitCount(xor));
            }
        }

        return totalBitDifference;
    }
    

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number : ");
        int n = scan.nextInt();
        System.out.print("Enter k value : ");
        int k = scan.nextInt();
        kthBitSetUnset(n, k);
        binaryPalindrome(n);
        int nums[] = {2,2};
        System.out.println("Total Bit Difference : "+bitDifference(nums));


        scan.close();
    }
}