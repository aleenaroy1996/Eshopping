package com.shoppingapp.product;

import com.google.common.collect.Lists;

import javax.swing.text.StyledEditorKit;
import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
//        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
//
//        List S = myList.stream()
//                .sorted(Comparator.reverseOrder()).distinct()
//                .collect(Collectors.toList());
//        System.out.println(S);

//        String s ="SARAS";
//        String res = "";
//        StringBuffer sb = new StringBuffer(s);
//        String res = String.valueOf(sb.reverse());
//        if(res.equals(s)){
//            System.out.println("Palindrome");
//        }
//        else{
//            System.out.println("not Palindrome");
//        }
//        for (int i = 0; i < s.length(); i++) {
//            res = s.charAt(i)+res;
//        }
//        System.out.println(res);
//
//        if(res.equals(s)){
//            System.out.println("Palindrome");
//        }
//        else{
//            System.out.println("not Palindrome");
//        }
//        String input = "ln";
//
//        System.out.println(input.toLowerCase().matches(".*[aeiou].*"));
//        System.out.println(isPrime(2)); // true
//        int a = 0;
//        int b = 1;
//        int c = 1;
//        int count = 10;
//        List res = new ArrayList<>();
//
//        for (int i = 1; i <= count; i++) {
////            System.out.print(a + ", ");
//            res.add(a);
//
//            a = b;
//            b = c;
//            c = a + b;
//        }
//        System.out.println(onlyOddNumbers(List.of(2,6,4,8)));
//        String s = "  abc  def\t";
//
//        s = s.trim();
//
//       System.out.println(factorial(3));
//        List<Integer> letters = Lists.newArrayList(1,2,3,4,5);
//
//        List<Integer> reverseSortedLetters = letters.stream()
//                .sorted(Comparator.reverseOrder())
//                .collect(Collectors.toList());
//        System.out.println(reverseSortedLetters);
//        int res=0;
//        int n = 123;
//        while(n != 0) {
//            n = n/10;
//            res++;
//        }

//        String S = "abccfuba";
//        StringBuilder sb = new StringBuilder();
//        Set<Character> set = new HashSet<>();
//
//
//        for(int i=0;i<S.length();i++) {
//            char ch = S.charAt(i);
//            if(S.lastIndexOf(ch)== S.indexOf(ch)){
//                sb.append(ch);
//            }
//        }
        Integer [] arr = {10, 20, 30, 40, 50};
        Collections.reverse(Arrays.asList(arr));
        System.out.println(Arrays.asList(arr));



    }
}
//    public static long factorial(long n) {
//        if (n == 1)
//            return 1;
//        else
//            return (n * factorial(n - 1));
//    }

//    public static boolean onlyOddNumbers(List<Integer> list) {
//        return list
//                .parallelStream() // parallel stream for faster processing
//                .allMatch(x -> x % 2 == 1); // return as soon as any elements match the condition
//    }


//        public static boolean isPrime(int n) {
//            if (n == 0 || n == 1) {
//                return false;
//            }
////            if (n == 2) {
////                return true;
////            }
//            for (int i = 2; i < n; i++) {
//                if (n % i == 0) {
//                    return false;
//                }
//            }
//
//            return true;



//        }



