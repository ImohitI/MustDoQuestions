package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        Scanner scanner = new Scanner(System.in);
//
//        int f = scanner.nextInt();
//
//        int s = scanner.nextInt();
//
//        scanner.nextLine();
//        int t = scanner.nextInt();
//
//        System.out.println(">>"+f);
//        System.out.println(">>"+s);
//        System.out.println(">>"+t);


        int[] array2 = {1,2};

        MyClass m = new MyClass();

        int[] arry3 = m.chetan(array2);

        System.out.println(">> "+array2[0]+" >> "+arry3[0]);

    }
}
