/**
 * This algorithm used for find a sub array of given array,
 * which has maximum summed of contiguous values. This is recursive
 * algorithm with divide and conquer approach. The idea is halving array
 * two side from middle point and working parallel with two sides of array.
 * There is an additional method in case of sub array is crossing middle point.
 * This algorithm performs in O(n lg n).
 * Additional note : This time complexity can be reduced to O(n), with optimizing 'Dynamic Programming'
 * approach. See 'The Kadane's algorithm'.
 *
 */

public class MaxSumSubArrayRecursive {
    /**
     * find sub array which has maximum summed value given array's elements.
     * @param arr - parent array which we are looking for maximum summed sub array
     * @param low - begin index
     * @param high - last index
     * @return maxSub - array represents founded sub array's begin index as maxSub[0], last index as maxSub[1]
     * and sum of its values as maxSub[2];
     */
    public static int[] maxSubArray(int[] arr, int low, int high){
        // initialize array for returned values
        int[] maxSub= new int[3];
        // deep statement which array has one element
        if (high == low){
            maxSub[0] = low;
            maxSub[1] = high;
            maxSub[2] = arr[low];
            return maxSub;
        }
        // array size > 1 , divide array halve
        else {
            int mid = ((high-low)/2)+low;
            // recursive statement
            int[] leftSub = maxSubArray(arr, low, mid);
            int[] rightSub = maxSubArray(arr,mid+1,high);
            int[] crossSub = maxCrossingSubArray(arr, low, mid, high);

            // merge statement
            // check for sum of left sub, right sub and cross sub. return array which has maximum summed value
            if (leftSub[2] >= rightSub[2] && leftSub[2] >= crossSub[2])  maxSub = leftSub;
            else if (rightSub[2] >= leftSub[2] && rightSub[2] >= crossSub[2]) maxSub = rightSub;
            else maxSub = crossSub;
            return maxSub;
        }
    }

    /**
     * This additional method finds max summed sub array whatever sub array is crossing whole array's middle point.
     * This returned array will be compared later with left-side and right-side of parent array.
     * @param arr - array to be found its max summed sub array
     * @param low - begin index
     * @param mid - middle index
     * @param high - last index
     * @return crossSub - this array represents sub array's begin index as crossSub[0], last index as crossSub[1]
     * and sum of its values as crossSub[2].
     */
    public static int[] maxCrossingSubArray(int[] arr,int low, int mid, int high){
        // init an array for returned values
        int[] crossSub = new int[3];
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid;i >=low;i--){
            sum = sum + arr[i];
            if (sum > leftSum){
                leftSum = sum;
                crossSub[0]=i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int j = mid+1;j <= high;j++){
            sum = sum + arr[j];
            if (sum > rightSum){
                rightSum = sum;
                crossSub[1] = j;
            }
        }
        crossSub[2] = rightSum + leftSum;
        return crossSub;
    }




}
