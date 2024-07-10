public class StringsJava {
    public static void main(String[] args) {
        String str1 = "Hello World!";     //String Literals
        String str2 = new String("hello world!");    //String Object
        // System.out.println(str1+str2);

        // System.out.println("String Length: "+str1.length());
        // System.out.println(str1.substring(1, 8));
        // System.out.println(str1.indexOf('l'));  // Returns the first occuring index of the char in the String.
        // System.out.println(str1.indexOf("lo"));
        // System.out.println(str1.concat(str2));
        // System.out.println(str1.toLowerCase());
        // System.out.println(str1.toUpperCase());
        // System.out.println(str1.replace("llo", "sso"));
        // System.out.println(str1.contains("Hiii"));
        // System.out.println(str1.contains("Hiii"));
        // System.out.println(str1.contains("0"));
        // System.out.println(str1.isEmpty());
        // if(str1==str2){
        //     System.out.println("True");
        // }else{
        //     System.out.println("False");
        // }
        // str2.concat(str1);
        // System.out.println(str2);
        System.out.println(equalString(str1, str2));
    }
    static boolean equalString(String str1, String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        if(len1==len2){
            System.out.println(str1.equals(str2));
            return str1.equalsIgnoreCase(str2);
        }
        return false;
    }
}
/*
StringBuffer:-

StringBuffer is a class in Java that represents a mutable sequence of characters. It provides an alternative to the immutable String class, allowing you to modify the contents of a string without creating a new object every time.


Comparison between String, StringBuilder, and StringBuffer
String:-

Introduced in JDK 1.0
Immutable
Thread Safe
High
High(No-Synchronization)
This is used when we want immutability.

StringBuilder:- 

Introduced in JDK 1.5
Mutable
Not Thread Safe
Efficient
High(No-Synchronization)
This is used when Thread safety is not required.

StringBuffer:-

Introduced in JDK 1.0
Mutable
Thread Safe
Less Efficient
Low(Due to Synchronization)
This is used when Thread safety is required.

 */