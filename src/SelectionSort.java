/**
 * This algorithm sort given array in place.
 * Time complexity of this algorithm ;
 * in the best case : O(n^2) ( it will look up inner loop anyway)
 * in the worst case : O(n^2)
 */
public class SelectionSort {
    /**
     *
     * @param arr unsorted array
     * @return arr - sorted array
     */
     @SuppressWarnings("UnusedReturnValue")
     public static int[] sort(int[] arr){
        // outer loop for replace minimum to bigger
        // from first index to last index
        // also we use i to arr.length-2 because
        // the last remaining index already the biggest one
        for (int i=0;i< arr.length-1;i++){
            // value of looked up index
            int key = arr[i];
            // we set to min value looked up index
            // in case of if it is min value in the remaining integers
            // after inner loop it will remain same
            int min = arr[i];
            int minIndex=i;
            // inner loop for look remaining integers (right-hand side)
            // we equals iterator 'j' to 'i' because
            // left-hand side of array already sorted
            for (int j = i; j< arr.length; j++){
                // if there is lower value change it with our value
                if (arr[j]<min){
                    min = arr[j];
                    minIndex=j;
                }
            }
            // we assign founded minimum value
            arr[minIndex]=key;
            arr[i]=min;
        }
        return arr;
    }
}
