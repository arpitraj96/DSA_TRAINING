public class Functions {
    public static void main(String[] args) {
        Addition add = new Addition();
        System.out.println(add.sum(3, 4));
        System.out.println(add.sum(3, 4, 7));
        System.out.println(smallest(25, 37, 29));
        System.out.println(properPrefix("appleananyaapple"));
    }
    static int smallest(int a, int b, int c){
        // int[] arr = {a, b, c};
        int min = a;
        // for(int i=1; i<3; i++){
        //     if(min>arr[i]){
        //         min = arr[i];
        //     }
        // }
        if(min>b){
            min = b;
        }
        if(min>c){
            min = c;
        }
        return min;
    }
    static int properPrefix(String str){
        int head1 = 0;
        int head2 = 1;
        int ans = 0;
        while (head1<str.length() && head2<str.length()) {
            if(str.charAt(head1)==str.charAt(head2)){
                head1++;
                head2++;
                ans++;
            }else{
                head2++;
            }
        }
        return ans;
    }
}
class Addition{
    int sum(int a, int b){
        return a+b;
    }
    // Function Over
    int sum(int a, int b, int c){
        return a+b+c;
    }
}