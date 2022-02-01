/**
 * Time complexity of this algorithm ;
 * in worst case : O(n^2)
 * in best casse : O(n)
 * it is good to use this algorithm with small sized data
 */

public class InsertionSort {
    /**
     * this method sorts array in place
     * @param arr unsorted array
     * @return arr sorted array
     */
    static int[] sort(int[] arr){
        // iterate array to sort all of them
        // we start with index 1 because
        // first element of array already sorted
        for (int i=1;i<arr.length;i++){
            int value=arr[i];
            // we define 'j' to iterate left-hand side array
            // which is already sorted
            int j=i-1;
            // move one right side each element bigger than our value
            while (j>=0 && arr[j]>value){
                arr[j+1]=arr[j];
                j=j-1;
            }
            // while nothing to left to move
            // replace value it's right index
            arr[j+1]=value;
        }
        return arr;
    }
}
