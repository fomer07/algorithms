/**
 * Horner algorithm also known as "horner method" used for
 * evaluate polynomials for given 'x' value. This allows evaluation
 * of polynomial with degree 'n', with n multiplication and n addition.
 * It is useful when evaluating high degree polynomials with O(n) time complexity.
 *
 */
public class HornerRule {
    /**
     * this method evaluate and return result of polynomial.
     * provided array must include all coefficients of polynomial for
     * all degree in descending order for degrees. For example, given 2x^3+0x^2-7x+5 polynomial's
     * array is {2,0,-7,5}
     * @param arr coefficients of polynomial
     * @param x  x value for evaluate polynomial
     * @return result- result of polynomial expression
     */
    public static int horner(int[] arr,int x){
        int result = 0;
        for (int i=0;i< arr.length;i++){
            result = arr[i]+x*result;
        }
        return result;
    }
}
