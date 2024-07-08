// Day = 01

import java.util.ArrayList;
import java.util.Scanner;

public class NumberSystemConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Conversion from Decimal
        System.out.print("Enter a decimal number: ");
        int dec = sc.nextInt();
        System.out.print(dec + " into Binary: ");
        System.out.println(convertDecimalToBinary1(dec));
        System.out.print(dec + " into Binary: ");
        String ans = convertDecimalToBinary2(dec);
        System.out.println(String.join("", ans));
        System.out.print(dec + " into Octal: ");
        System.out.println(convertDecimalToOctal(dec));
        System.out.print(dec + " into HexDecimal: ");
        System.out.println(convertDecimalToHex(dec));

        // Conversion from Binary
        System.out.print("Enter a Binary number: ");
        int bin = sc.nextInt();
        System.out.print(bin + " into Decimal: ");
        System.out.println(convertBinaryToDecimal(bin));
        System.out.print(bin + " into Octal: ");
        System.out.println(convertBinaryToOctal(bin));
        System.out.print(bin + " into HexaDecimal: ");
        System.out.println(convertBinaryToHex(bin));

        // Conversion from Octal
        System.out.print("Enter a Octal number: ");
        int oct = sc.nextInt();
        System.out.print(oct + " into Decimal: ");
        System.out.println(convertOctalToDecimal(oct));
        System.out.print(oct + " into Binary: ");
        System.out.println(convertOctalToBinary(oct));
        System.out.print(oct + " into HexaDecimal: ");
        System.out.println(convertOctalToHex(oct));

        // Conversion from HexaDecimal
        System.out.print("Enter a HexaDecimal number: ");
        int hex = sc.nextInt();
        System.out.print(hex + " into Decimal: ");
        System.out.println(convertHexToDecimal(hex));
        System.out.print(hex + " into Binary: ");
        System.out.println(convertHexToBinary(hex));
        System.out.print(hex + " into Octal: ");
        System.out.println(convertHexToOctal(hex));
        sc.close();
    }

    // 1st Approach
    static int convertDecimalToBinary1(int num) {
        int binary = 0;
        int place = 1;
        while (num > 0) {
            int rem = num % 2;
            binary = binary + rem * place;
            num /= 2;
            place *= 10;
        }
        return binary;
    }

    // 2nd Approach
    static String convertDecimalToBinary2(int num) {
        ArrayList<Integer> arr = new ArrayList<>();
        int rem;
        while (num > 0) {
            rem = num % 2;
            arr.add(0, rem);
            num /= 2;
        }
        return arr.toString();
    }

    static int convertBinaryToDecimal(int num) {
        int dec = 0;
        int i = 0;
        while (num > 0) {
            int rem = num % 10;
            dec += (int) Math.pow(2, i) * rem;
            i++;
            num /= 10;
        }
        return dec;
    }

    static int convertDecimalToOctal(int num) {
        int octal = 0;
        int place = 1;
        while (num > 0) {
            int rem = num % 8;
            octal = octal + rem * place;
            num /= 8;
            place *= 10;
        }
        return octal;
    }

    static int convertBinaryToOctal(int num) {
        int dec = 0;
        int i = 0;
        while (num > 0) {
            int rem = num % 10;
            dec += (int) Math.pow(2, i) * rem;
            i++;
            num /= 10;
        }
        int octal = convertDecimalToOctal(dec);
        return octal;
    }

    static String convertDecimalToHex(int num) {
        StringBuilder hexBuilder = new StringBuilder();

        while (num > 0) {
            int rem = num % 16;
            if (rem < 10) {
                hexBuilder.insert(0, rem); // Append digit 0-9
            } else {
                hexBuilder.insert(0, (char) ('A' + (rem - 10))); // Append character A-F
            }
            num /= 16;
        }
        return hexBuilder.toString();
    }

    static String convertBinaryToHex(int num) {
        int dec = convertBinaryToDecimal(num);
        String hex = convertDecimalToHex(dec);
        return hex;
    }

    static int convertOctalToDecimal(int num) {
        int dec = 0;
        int i = 0;
        while (num > 0) {
            int rem = num % 10;
            dec += (int) Math.pow(8, i) * rem;
            i++;
            num /= 10;
        }
        return dec;
    }

    static int convertOctalToBinary(int num) {
        int dec = convertOctalToDecimal(num);
        int bin = convertDecimalToBinary1(dec);
        return bin;
    }

    static String convertOctalToHex(int num) {
        int dec = convertOctalToDecimal(num);
        String hex = convertDecimalToHex(dec);
        return hex;
    }

    static int convertHexToDecimal(int num) {
        int dec = 0;
        return dec;
    }

    static int convertHexToBinary(int num) {
        int bin = 0;
        return bin;
    }

    static int convertHexToOctal(int num) {
        int oct = 0;
        return oct;
    }
}