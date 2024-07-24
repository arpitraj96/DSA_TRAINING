package VJudge;
import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s1.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
        }
        for (int count : charCount.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String str1 = parts[0];
            String str2 = parts[1];

            if (areAnagrams(str1, str2)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }

        sc.close();
    }
}
