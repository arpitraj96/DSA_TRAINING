package VJudge;

// import java.util.Scanner;

// public class ReverseString {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int t = sc.nextInt();
//         sc.nextLine();
//         while (t>0) {
//             String str = sc.nextLine();
//             reverse(str);
//             t--;
//         }
//         sc.close();
//     }
//     static void reverse(String str){
//         for(int i=str.length()-1; i>=0; i--){
//             System.out.print(str.charAt(i));
//         }
//         System.out.println();
//     }
// }

import java.util.Scanner;
import java.util.Stack;

public class ReverseSentence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); 
        
        for (int t = 0; t < T; t++) {
            String sentence = sc.nextLine();
            String reversedSentence = reverseSentence(sentence);
            System.out.println(reversedSentence);
        }
        
        sc.close();
    }

    private static String reverseSentence(String sentence) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            stack.push(word);
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }
        return result.toString().trim();
    }
}
