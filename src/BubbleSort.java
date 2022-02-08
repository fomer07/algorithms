/**
 * Bubble sorting,compare and swap all pair of values trough array.
 * To achieve this, iterate, start to end and end to start.It performs
 * O(n^2) in the worst case like insertion sort algorithm. But in the best case
 * it performs in O(n^2) time too. That's why it is inefficient when we compare
 * it with insertion sort algorithm. Also, this case leads important of using
 * "while" instead of "for" in insertion sort algorithm.
 *
 */

public class BubbleSort {

    /**
     * this method responsible for sorting given array
     * with bubble sort algorithm.
     * @param arr unsorted array
     * @return arr - sorted array
     */
    public static int[] bubbleSort(int[] arr){
        // iterate array from start to end
        for (int i=0;i<arr.length-1;i++){
            // iterate array in reverse order
            for (int j = arr.length-1;j>i;j--){
                if (arr[j]<arr[j-1]) {
                    // swap values
                    int temp = arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }

}
