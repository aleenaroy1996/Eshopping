package com.shoppingapp.product;

import java.util.*;
import java.util.stream.Collectors;

public class Sample {

    public static void main(String[] args) {
//        String str = "makayalamb";
//        String res ="";
//        for(int i=0;i<str.length()-1;i++){
//            char ch = str.charAt(i);
//            if(str.indexOf(ch) == str.lastIndexOf(ch)){
//                res= res+ch;
//                break;
//            }
//        }
//        System.out.println(res);
//        Scanner scn = new Scanner(System.in);
//        String inputStr = scn.next();
//        String ch = scn.next();
//        String rech = scn.next();
//
//        String res = inputStr.replace(ch,rech);
//        System.out.println(res);

        int arr[] = {3,4, 5,8 ,24};
        int n = arr.length;
//        //bubble sort
//        for(int i=0;i<n-1;i++){
//            for(int j=0;j<n-i-1;j++){
//                if(arr[j]>arr[j+1]){//ascending
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
//
//        System.out.println(Arrays.toString(arr ));

        // selection sort
//        for(int i=0;i<n-1;i++){
//            int smallestIndex = i;
//            for (int j=i+1;j<n;j++){
//                if(arr[smallestIndex]>arr[j]){//ascending
//                    smallestIndex = j;
//                }
//            }
//
//            int temp = arr[i];
//            arr[i] = arr[smallestIndex];
//            arr[smallestIndex]=temp;
//        }
//        System.out.println(Arrays.toString(arr ));

        //insertion sort
//        for(int i=1;i<n;i++){
//            int current = arr[i];
//            int j = i-1;
//            while(j>=0 && current<arr[j]){//ascending
//                arr[j+1]=arr[j];
//                j--;
//            }
//
//            arr[j+1]=current;
//        }
//        System.out.println(Arrays.toString(arr ));
//        quickSort(arr, 0, n-1);
//
//        System.out.println(Arrays.toString(arr ));




        System.out.println(binarySearch(arr,24));


    }

    //bonary search
    public static String binarySearch(int[] arr,  int x){

        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;

            // Check if x is present at mid
            if (arr[m] == x)
                return "Element found at index "+m;

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return "Element  not found ";
    }



    // linear search
//    public static String linearSearch(int[] arr, int x){
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]==x){
//                return "Element found at index " + i;
//            }
//        }
//        return "Element not found";
//    }

//    public static int partition(int[] arr, int low, int high){
//
//            int i = low - 1;
//            int pivot = arr[high];
//            for (int j = low; j < high; j++) {
//                if (arr[j]<pivot){//ascending
//                    i++;
//                    //swap
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//
//            }
//
//            i++;
//            int temp = arr[i];
//            arr[i]=pivot;
//            arr[high] = temp;
//            return i;
//        }
//
//
//    public static void quickSort(int[] arr, int low, int high){
//        if(low<high) {
//            int pivotIndex = partition(arr, low, high);
//
//
//            quickSort(arr, low, pivotIndex - 1);
//            quickSort(arr, pivotIndex + 1, high);
//        }
//    }

}
