/**
 * This algorithm used for search an arbitrary value
 * in sorted array. It works with divide and conquer
 * technic. It performs with O(log (n)), which is faster
 * than linear search but as mentioned earlier given array
 * must be sorted.
 * Note: if given array includes 'value' more than 1 time, it will
 * return index of what it found first.
 *
 */
/*
    As example, in this given array if we are looking for value '9',
    [3,4,8,9,9,12,14,15,16,23,26,30,38,38,40,40,42,46,50,52,54,58,63,67,78,78,92,93,96,97]
    it will return index 4.
 */
public class BinarySearch {

    /**
     * this method divide half given array, find
     * middle index of array, take it as reference to compare
     * with what we are looking for.
     * @param arr - sorted array (lower to higher)
     * @param b - begin index of array
     * @param l - last index of array
     * @param v - searched value
     * @return - return index of value. if it can't find return -1.
     */
    public static int binarySearch(int[] arr,int b,int l, int v){
        // find middle index
        int m = b+(l-b)/2;

        if (arr[m] == v) return m;
        // if value of middle index bigger than 'v' look left side of array
        else if (arr[m] > v && b<=m-1) return binarySearch(arr,b,m-1,v);
        // if value of middle index lower than 'v' look right side of array
        else if (arr[m] < v && m+1<=l ) return binarySearch(arr,m+1,l,v);
        //  could not find value return -1

        return -1;
    }
}
