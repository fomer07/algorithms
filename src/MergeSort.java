/**
 * Merge sort is recursive algorithm
 * works with divide and conquer technic.
 * time complexity of this algorithm ;
 * in the best and worst case performs :
 * for T(n)=2T(n/2)+O(n) leads  O(n log(n)).
 * it is pretty speed for sorting data sets
 * with tradeoff recurring high memory space.
 */

public class MergeSort {

    /**
     * recursive method to divide array into halves
     * until beginIndex >= lastIndex. in this case
     * array has at most 1 element, and it always sorted.
     * then merge them into complete array.
     * @param arr unsorted array
     * @param beginIndex begin index of array
     * @param lastIndex last index of array
     */
    public static void mergeSort(int[]arr,int beginIndex,int lastIndex){
        if (beginIndex<lastIndex){
            int middleIndex = (lastIndex+beginIndex)/2;
            mergeSort(arr,beginIndex,middleIndex);
            mergeSort(arr,middleIndex+1,lastIndex);
            merge(arr,beginIndex,middleIndex,lastIndex);
        }
    }

    /**
     * this method divide halve given array
     * in this provided array left-side and right-side
     * arrays must be sorted itself. with this method
     * we look two sub-arrays and create new form of sorted to
     * whole array.
     * @param arr array to be modified
     * @param beginIndex begin index
     * @param middleIndex middle index
     * @param lastIndex last index
     */
    static void merge(int[] arr,int beginIndex,int middleIndex,int lastIndex){
        // evaluate sub-arrays length
        int leftSize = middleIndex-beginIndex+1;
        int rightSize = lastIndex-middleIndex;
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        //copy array into sub-arrays
        System.arraycopy(arr, beginIndex, leftArray, 0, leftSize);
        System.arraycopy(arr,middleIndex+1,rightArray,0,rightSize);

        int leftIndex=0;
        int rightIndex=0;
        int mainIndex = beginIndex;

        // compare sub-arrays given index value
        // add to lower one to main array
        while (leftIndex<leftArray.length && rightIndex<rightArray.length){
            if (leftArray[leftIndex]<=rightArray[rightIndex]){
                arr[mainIndex]=leftArray[leftIndex];
                leftIndex++;
            }else {
                arr[mainIndex]=rightArray[rightIndex];
                rightIndex++;
            }
        mainIndex++;
        }
        // in case of one of them finish before than other
        // copy the remaining elements
        while (leftIndex<leftArray.length){
            arr[mainIndex]=leftArray[leftIndex];
            leftIndex++;
            mainIndex++;
        }
        while (rightIndex<rightArray.length){
            arr[mainIndex]=rightArray[rightIndex];
            rightIndex++;
            mainIndex++;
        }
    }
}
