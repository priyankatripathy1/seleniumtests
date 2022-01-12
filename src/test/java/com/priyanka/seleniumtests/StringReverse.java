package com.priyanka.seleniumtests;

public class StringReverse {
    public static void main(String args[])
    {
        String name="priyanka";
        reverseChar(name);

    }

    public static void reverseChar(String name){
        char ch[]=name.toCharArray();
        //String output= "";

        for(int i=ch.length-1;i>=0;i--){
            System.out.println(ch[i]);
        }
    }
}
