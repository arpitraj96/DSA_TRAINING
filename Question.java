public class Question {
    public static void main(String[] args) {
        System.out.println(asciiChange("interviews", 10));
    }
    static String asciiChange(String str, int num) {
        str = str.toLowerCase();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                char shiftedChar = (char) ((ch - 'a' + num) % 26 + 'a');
                ans.append(shiftedChar);
            } else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}