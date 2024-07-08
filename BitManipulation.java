import java.util.Scanner;

public class BitManipulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // GET
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        System.out.print("Enter the position: ");
        int position = sc.nextInt();
        int bitMask = 1<<position;
        int bitwiseAND = bitMask & n;
        int bitwiseXOR = bitMask ^ n;
        int bitwiseOR = bitMask | n;
        int bitwiseCOMPLEMENT = ~ bitMask;
        System.out.println(bitwiseAND);
        System.out.println(bitwiseXOR);
        System.out.println(bitwiseOR);
        System.out.println(bitwiseCOMPLEMENT);
        sc.close();
    }
     // Get the nth bit of an integer x
     static boolean getBit(int x, int n) {
        return ((x >> n) & 1) == 1;
    }
    
    // Set the nth bit of an integer x to 1
    static int setBit(int x, int n) {
    return x | (1 << n);
    }

    // Update the nth bit of an integer x to a new value (0 or 1)
    static int updateBit(int x, int n, int newValue) {
    int mask = ~(1 << n); // Clear the nth bit
    return (x & mask) | (newValue << n);
    }

    // Clear the nth bit of an integer x
    static int clearBit(int x, int n) {
    int mask = ~(1 << n); // Create a mask with the nth bit set to 0
    return x & mask; // Clear the nth bit in x
    }

    static int clearAllBits(int x) {
        return 0;
    }
    
    // Clear bits from bit start to bit end in integer x
    static int clearBitsInRange(int x, int start, int end) {
    int mask = (~0 << (end + 1)) | ((1 << start) - 1);
    return x & mask;
    }

}
