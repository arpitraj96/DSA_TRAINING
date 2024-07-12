public class Searching {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(linearSearch(arr, 3));
        System.out.println(binarySearch(arr, 5));
    }   
    static int linearSearch(int[] arr, int target){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
    static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length;
        while (left<right) {
            int mid = (left+right)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]<target)
                left = mid+1;
            else
                left = mid-1;
        }
        return -1;
    }
}
/*
 Arrays can be searched by comparing the values of some array elements with the required value.

 Types:-
 1. Sequential(Linear) Search 
    |--> Average and Worst Case -> O(N)
 2. Binary Search -> Works by halving the number of elements to look through in each iteration, hence reduving the number of elements to be searched.
    |--> Average and Worst Case -> O(log N)
*/