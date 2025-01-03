package edu.dsa.sorts;

public class QuickSort2 {
    
    int partition(int arr[], int low, int high) { 
        int pivot = arr[high]; 
        int i = (low - 1); // Index of smaller element 
        for (int j = low; j < high; j++) { 
            // If current element is smaller than or equal to pivot 
            if (arr[j] <= pivot) { 
                i++; 
                // Swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
        // Swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i + 1]; 
        arr[i + 1] = arr[high]; 
        arr[high] = temp; 
        return i + 1; 
    }   
 
    
    void quickSort(int arr[], int low, int high) { 
        if (low < high) { 
            int pi = partition(arr, low, high); 
            // Recursively sort elements before and after partition 
            quickSort(arr, low, pi - 1); 
            quickSort(arr, pi + 1, high); 
        }    
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 5, 7, 9, 1, 3};
        QuickSort2 quickSort2 = new QuickSort2();
        quickSort2.quickSort(arr, 0, arr.length - 1);
        for ( int i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }
}
