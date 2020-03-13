package com.sorting.quickSort;

public class ArrayQuickSort {

    public static void main(String[] args) {
        ArrayQuickSort qSort = new ArrayQuickSort();
        int[] arr = {2,11,4,8,6,7};
        qSort.quickSort(arr,0, arr.length-1);
        qSort.printArray(arr);

    }

    public void quickSort(int[] arr, int begin, int end){

        if(begin<end){

            int partition = partition(arr, begin, end);

            quickSort(arr,begin,partition-1);
            quickSort(arr,partition+1, end);
        }

    }

    private int partition(int[] arr, int begin , int end){

        int pivot = arr[end];
        int j=begin-1;
        int temp =0;
        for(int i= begin; i<end; i++){
            if(arr[i]<= pivot){
                j++;

                temp = arr[j];
                arr[j]= arr[i];
                arr[i]= temp;
            }
        }

        temp = arr[j+1];
        arr[j+1] = arr[end];
        arr[end] = temp;

        return j+1;
    }

    public void printArray(int[] arr){

        for(int i:arr){
            System.out.print(i+",");
        }
    }

}
