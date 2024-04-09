package com.dsa_basics;

public class Arrays {
    public static void main(String[] args) {
        // reverse an array
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        reverseArray(arr, 0, 5);
        System.out.println(java.util.Arrays.toString(arr));

        int arr1[] = { 1, 2, 3, 4, 5, 6 };
        rotateArray(arr1);
        System.out.println(java.util.Arrays.toString(arr1));

        // find maximum contiguous subarray
        // int[] arr2 = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int[] arr2 = { -2, -3, -4, -1, -2, -1, -5, -3 };

        System.out.println("Maximum contiguous sum is "
                + maxSubArraySum(arr2));
        int arr3[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        int arr_size = arr3.length;
        sort012(arr3, arr_size);
        System.out.println(java.util.Arrays.toString(arr3));

        // Define the matrix
        int[][] arr4 = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
                { 10, 11, 12 } };

        // Start the traversal from the top-left corner of the
        // matrix
        MatrixTraversal.traverse(arr4, 0, 0);

        // rotate a matrix
        int a[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        // rotate matrix elements

        rotatematrix(4, 4, a);
    }

    // Dutch national flag
    public static void sort012(int a[], int size) {
        int low = 0;
        int high = size - 1;
        int mid = 0, temp = 0;
        // Iterate till all the elements are sorted
        while (mid < high) {
            switch (a[mid]) {
                // if element is 0
                case 0: {
                    temp = a[low];
                    a[low] = a[mid];
                    a[mid] = temp;
                    low++;
                    mid++;
                    break;
                }
                // if element is 1
                case 1:
                    mid++;
                    break;
                case 2: {
                    temp = a[mid];
                    a[mid] = a[high];
                    a[high] = temp;
                    high--;
                    break;
                }

            }
        }
    }

    // kadane algorithm
    // { -2, -3, 4, -1, -2, 1, 5, -3 }
    private static int maxSubArraySum(int[] arr) {
        int size = arr.length;
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + arr[i];
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }
        return max_so_far;
    }

    // cyclic rotation
    private static void rotateArray(int[] arr) {
        int end = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = end;
    }

    // TC O(n) AS O(1)
    private static void reverseArray(int[] arr, int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }

    public class MatrixTraversal {

        private static final int C = 3;
        private static final int R = 4;

        private static void traverse(int[][] arr, int i, int j) {
            if (i == R - 1 & j == C - 1) {
                System.out.println(arr[i][j]);
                return;
            }
            // Print the value at the current position
            System.out.println(arr[i][j] + ",");

            // If the end of the current row has not been reached
            if (j < C - 1) {
                // move right
                traverse(arr, i, j + 1);
                // If the end of the current column has been reached
            } else if (i < R - 1) {
                // move down
                traverse(arr, i + 1, 0);

            }

        }
    }

    public static void rotatematrix(int r, int c, int mat[][]) {

        /**
         * 00 01 02 03 04
         * 10 11 12 13 14
         * 20 21 22 23 24
         * 30 31 32 33 34
         */
        int row = 0, col = 0;
        int prev, curr;
        int R = r, C = c;
        /*
         * row - Starting row index
         * r - ending row index
         * col - starting column index
         * c - ending column index
         * i - iterator
         */
        while (row < r && col < c) {
            System.out.println(" row " + row + " col " + col);
            System.out.println(" r " + r + " c " + c);
            if (row + 1 == r || col + 1 == c)
                break;

            // Store the first element of next
            // row, this element will replace
            // first element of current row
            prev = mat[row + 1][col];

            // Move elements of first row
            // from the remaining rows
            for (int i = col; i < c; i++) {
                curr = mat[row][i];
                mat[row][i] = prev;
                prev = curr;
            }
            row++;

            // Move elements of last column
            // from the remaining columns
            for (int i = row; i < r; i++) {
                curr = mat[i][c - 1];
                mat[i][c - 1] = prev;
                prev = curr;
            }
            c--;

            // Move elements of last row
            // from the remaining rows
            if (row < r) {
                for (int i = c - 1; i >= col; i--) {
                    curr = mat[r - 1][i];
                    mat[r - 1][i] = prev;
                    prev = curr;
                }
            }
            r--;

            // Move elements of first column
            // from the remaining rows
            if (col < c) {
                for (int i = r - 1; i >= row; i--) {
                    curr = mat[i][col];
                    mat[i][col] = prev;
                    prev = curr;
                }
            }
            col++;
        }

        // Print rotated matrix
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++)
                System.out.print(mat[i][j] + " ");
            System.out.print("\n");
        }
    }

}
