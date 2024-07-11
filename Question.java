public class Question {
    public static void main(String[] args) {
        // System.out.println(asciiChange("interviews", 10));
        System.out.println(teamDivision(7));
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
    static int teamDivision(int num){
        if(num%2==0){
            int tEven=0;
            int tOdd = 0;
            for(int i=1; i<=num; i++){
                if(num%i==0){
                    if(i%2==0)
                        tEven++;
                    else
                        tOdd++;
                }
            }
            if(tEven==tOdd)
                return 1;
            else
                return 0;
        }else{
            return 0;
        }
    }
}