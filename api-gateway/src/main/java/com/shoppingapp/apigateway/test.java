package com.shoppingapp.apigateway;

public class test {
    public static void main(String[] args){
        String s = "ab#cd#d#";
        String res ="";

        for(int i=1;i<s.length()-1;i++){

            if(('#'== s.charAt(i+1))){
                res=res+s.charAt(i-1);

            }
        }
        System.out.println(res);
    }
}
