import java.util.*;

/**
  This class impelents sort algorithms
	
	@author ass_12-11
	@version v1.1
*/


public class SortExample{
	
	/**
	  main method to call sort algorithms
	
	   @param args Command line arguments
	*/
	public static void main(String[] args){
		
		// This is unsorted array
		Integer[] array1 = new Integer[] { 12, 13, 24, 10, 3, 6, 90, 70 };
		int array2[] = { 2, 6, 3, 5, 1 };
		
		// Let's sort using quick sort
		quickSort( array1, 0, array1.length - 1 );
		
		// Verify sorted array
		System.out.println(Arrays.toString(array1));
		mergeSort(array2, array2.length - 1 );
		
		// Verify sorted array
		System.out.println(Arrays.toString(array2));
	}
	
	/**
	  main method to execute quick sort algorithms
	
	   @param arr is input elements
	   @param low is input lower index of arr
	   @param high is input higher index of arr
	*/ 
	public static void quickSort(Integer[] arr, int low, int high){
		
		//check for empty or null array
		if (arr == null || arr.length == 0) return;
        if (low >= high) return;
		
		//Get the pivot element from the middle of the list
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
		
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j){
			
			//Check until all values on left side array are lower than pivot
			while (arr[i] < pivot){
				i++;
			}
			
			//Check until all values on left side array are greater than pivot
			while (arr[j] > pivot){
				j--;
			}
			
			//Now compare values from both side of lists to see if they need swapping 
			//After swapping move the iterator on both lists
			if (i <= j){
				swap (arr, i, j);
				i++;
				j--;
			}
		}
		
		//Do same operation as above recursively to sort two sub arrays
		if (low < j) quickSort(arr, low, j);
		
        if (high > i) quickSort(arr, i, high);
	}
	
	 /**
       Swaps two elements in the given array.
      
        @param array Array containing elements to swap
        @param x Index of the first element
        @param y Index of the second element
     */
	public static void swap (Integer array[], int x, int y){
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
	
	/**
      Executes the merge sort algorithm
  
       @param a Array of elements to be sorted
       @param n Number of elements in the array
     */
	public static void mergeSort(int[] a, int n){
		if (n < 2){
			return;
		}
		
		int mid = n / 2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];
		
		for (int i = 0; i < mid; i++){
			l[i] = a[i];
		}
		
		for (int i = mid; i < n; i++){
			r[i - mid] = a[i];
		}
		mergeSort(l, mid);
		mergeSort(r, n - mid);
		merge(a, l, r, mid, n - mid);
	}
	
	/**
      Merges two sorted subarrays into a single sorted array
      
       @param a Array to hold merged elements
       @param l Left subarray
       @param r Right subarray
       @param left Size of the left subarray
       @param right Size of the right subarray
     */
	public static void merge(int[] a, int[] l, int[] r, int left, int right){
		int i = 0, j = 0, k = 0;
		
		while (i < left && j < right){
			if (l[i] <= r[j]){
				a[k++] = l[i++];
			} else {
				a[k++] = r[j++];
			}
		}
		
		// Copy remaining elements from the left subarray
        while (i < left) a[k++] = l[i++];
		
		// Copy remaining elements from the right subarray
        while (j < right) a[k++] = r[j++];
	}
	
	/**
      Checks if an array is sorted in ascending order
      
       @param x Array to check
       @return True if sorted, otherwise false
     */
	private static boolean isSorted(int[] x){
		for (int i = 0; i < x.length - 1; i++)
            if (x[i] > x[i + 1]) return false;
        return true;
	}
}