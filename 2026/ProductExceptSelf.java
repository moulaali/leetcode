import java.util.Arrays;

/**
 * Given an input array, return an array of all products except the give number
 * Division is not allowed :)
 */
public class AllButSelfProduct {

    public static void main(String[] args) {
        // happy path
        System.out.println(Arrays.toString(getProductExceptSelf(new int[]{3, 2, 1, 4})));

        // empty array
        System.out.println(Arrays.toString(getProductExceptSelf(new int[]{})));

        // contains 0
        System.out.println(Arrays.toString(getProductExceptSelf(new int[]{3, 4, 2, 0, 1})));

        // contains negative integers
        System.out.println(Arrays.toString(getProductExceptSelf(new int[]{2, -3, -4})));

        // single element
        System.out.println(Arrays.toString(getProductExceptSelf(new int[]{2})));
    }

    /**
     * Returns an array of product of all numbers in the array except the ith
     *
     * Does not use division
     *
     * @param input
     * @return product array
     */
    static int[] getProductExceptSelf(int[] input) {
        int[] product = new int[input.length];

        if (input.length == 1) {
            return new int[] {input[0]};
        }

        // compute left cummilative
        int[] leftCummilative = new int[input.length];
        int cumProduct = 1;
        for (int i = 0; i < leftCummilative.length; i++) {
            cumProduct *= input[i];
            leftCummilative[i] = cumProduct;
        }

        // compute right cummilative
        int[] rightCummilative = new int[input.length];
        cumProduct = 1;
        for (int i = input.length - 1; i >= 0; i--) {
            cumProduct *= input[i];
            rightCummilative[i] = cumProduct;
        }

        // now compute the response array using i-1 product from leftcummilative
        // and i+1 product from right cummilative
        for (int i = 0; i < input.length; i++) {
            if (i == 0) {
                product[i] = rightCummilative[i + 1];
                continue;
            } else if (i == input.length - 1) {
                product[i] = leftCummilative[i - 1];
                continue;
            }

            product[i] = (rightCummilative[i + 1] * leftCummilative[i - 1]);
        }

        return product;
    }
}
