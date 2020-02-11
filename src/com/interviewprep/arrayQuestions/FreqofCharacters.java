package com.interviewprep.arrayQuestions;

import java.util.Arrays;

public class FreqofCharacters {


    public static void main(String[] args) {

        String str = "geeksforgeeks";
        //printCharWithFreq(str);
        printFreq(str);
    }
    static void printCharWithFreq(String str)
    {
        // size of the string 'str'
        int n = str.length();

        // 'freq[]' implemented as hash table
        int[] freq = new int[26];

        // accumulate freqeuncy of each character
        // in 'str'
        for (int i = 0; i < n; i++)
            freq[str.charAt(i) - 'a']++;

        // traverse 'str' from left to right
        for (int i = 0; i < n; i++) {

            // if frequency of character str.charAt(i)
            // is not equal to 0
            if (freq[str.charAt(i) - 'a'] != 0) {

                // print the character along with its
                // frequency
                System.out.print(str.charAt(i));
                System.out.print(freq[str.charAt(i) - 'a'] + " ");

                // update frequency of str.charAt(i) to
                // 0 so that the same character is not
                // printed again
                freq[str.charAt(i) - 'a'] = 0;
            }
        }
    }
    static void printFreq(String str){

        int count=1;
        char[] carray = str.toCharArray();

        Arrays.sort(carray);

        for(char c : carray){
            System.out.print(" "+c);
        }
        System.out.println();

        for(int i = 1; i<carray.length; i++){
            if(carray[i-1]==carray[i]){
                count++;
                if(i==carray.length-1)
                    System.out.println(" "+carray[i-1]+" frequency "+count);
            }else{
                System.out.println(" "+carray[i-1]+" frequency "+count);
                count = 1;
            }
        }
    }


}
