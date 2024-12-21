package edu.dsa.greedytech;

public class MaxSwap {
    
    public static int maximumSwapN2(int num) {
        char[] a = Integer.toString(num).toCharArray();
        int result = num;

        // swap most left number with max of right number
        // if not found then try with the next left no

        int rindex = -1;
        for(int i = 0; i < a.length ; i++) {
            char left = a[i];
            char rmax = left;
            for (int j = i + 1; j < a.length ; j++) {
                if (rmax <= a[j]) {
                    rindex = j;
                    rmax = a[j];
                }
            }
            if (rindex != -1) {
                char temp = a[i];
                a[i] = rmax;
                a[rindex] = temp;
                break;
            }
        }

        result = Integer.parseInt(new String(a));
        
        return num < result ? result : num ;
    } 

    public static int maximumSwapN1TwoPass(int num) {
        int result = num;
        char[] a = String.valueOf(num).toCharArray();
        int[] rmax = new int[a.length];
        rmax[a.length - 1] = a.length - 1;
        for (int i = a.length -2; i >=0; i--) {
            if (a[i] > a[rmax[i + 1]]) {
                rmax[i] = i;
            } else {
                rmax[i] = rmax[i + 1];
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] < a[rmax[i]]) {
                char temp = a[i];
                a[i] = a[rmax[i]];
                a[rmax[i]] = temp;
                break;
            }
        }

        return Integer.parseInt(new String(a));
    }

    //O(n) one pass
    public static int maximumSwap(int num) {
        char[] a = String.valueOf(num).toCharArray();
        int n = a.length;
        int maxi = -1, index1 = -1, index2 = -1;

        for (int i = n - 1; i >= 0; i--) {
            if (maxi == -1 || (a[i] > a[maxi])) {
                maxi = i;
            } else if (a[i] < a[maxi]) {
                index1 = i;
                index2 = maxi;
            }
        }

        if (index1 != -1 && index2 != -1) {
            char temp = a[index1];
            a[index1] = a[index2];
            a[index2] = temp;
        }

        return Integer.parseInt(new String(a));

    }

    public static void main(String[] args) {
        int[] nums = {1234, 4121, 87654, 1643, 123, 14};

        for (int i = 0; i < nums.length; i++) {
            System.out.println((i + 1) + ".\tNumber: " + nums[i]);
            System.out.println("\n\tLargest number after swapping: " + maximumSwap(nums[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }    
}
