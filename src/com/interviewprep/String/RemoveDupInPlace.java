package com.interviewprep.String;

import java.util.Arrays;

public class RemoveDupInPlace {
    public static void main(String[] args) {
        String s = "geeksforgeeks";

        System.out.println(unique(s));
        System.out.println(removeDups(s));
    }

    //Using toString
    public static String unique(String s){

        String str = new String();
        int len = s.length();

        for(int i=0; i< len;i++){
            char c = s.charAt(i);
            if(str.indexOf(c)<0){
                str += c;
            }
        }

      return str;
    }

    //Method to remove duplicate in sorted array
    public static String removeDups(String str){
        char temp[] = str.toCharArray();
        Arrays.sort(temp);
        str = new String(temp);

       // System.out.println(">> "+str.toString());
        int r_ind = 1, p_ind = 1;

        char arr[] = str.toCharArray();

        while(p_ind != arr.length){
            if(arr[p_ind] != arr[p_ind-1]){
                arr[r_ind] = arr[p_ind];
                r_ind++;
            }
            p_ind++;
        }

        str = new String(arr);

        return str.substring(0, r_ind);

    }
}
