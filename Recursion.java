public class Recursion {
    public static void main(String[] args) {
        // System.out.println(factorial(5));
        // printFib(8);
        // int n=0;
        // int t = 5;
        // for(int i=1; i<=t; i++){
        //     System.out.printf("%d\t",fib(n));
        //     n++;
        // }
        // System.out.println();
        // System.out.println(fibonaaci(8));
        // System.out.println(sumOfDigits(222));
        System.out.println(findStep(4));
    }
    static int factorial(int num){
        if(num==0){
            return 1;
        }
        else{
            return factorial(num-1)*num;
        }
    }
    static void fib(int n, int prev1, int prev2) {
        if (n < 3) {
            return;
        }
        int fn = prev1 + prev2;
        prev2 = prev1;
        prev1 = fn;
        System.out.print(fn + " ");
        fib(n - 1, prev1, prev2);
    }
    static void printFib(int n) {
        if (n < 1) {
            System.out.println("Invalid number of terms");
        }
        else if (n == 1) {
            System.out.println(0);
        }
        else if (n == 2) {
            System.out.println("0 1");
        }
        else {
            System.out.print("0 1 ");
            fib(n, 1, 0);
        }
    }
    static int fib(int n){
        if(n==1 || n==0 ){
            return n;
        }
        else{
            return fib(n-1)+fib(n-2);
        }
    }
    /*Question-> Given a staircase with n steps, count the number of distict ways to reach the top when you can take 1,2, or 3 steps at a time. */
    static int findStep(int num){
        if(num==0){
            return 1;
        }else if(num<0){
            return 0;
        }else{
            return findStep(num-1)+findStep(num-2)+findStep(num-3);
        }
    }
    static int sumOfDigits(int num){
        if(num<=9){
            return num;
        }
        return (num%10)+sumOfDigits(num/10);
    }
    
}
/*
 Recursion:-
 A function that calls itself to solve a problem.
 */