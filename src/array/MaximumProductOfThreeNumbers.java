package array;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {

    /* Solution1: Sort */
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;

        return Math.max(nums[0] * nums[1] * nums[len - 1], nums[len - 1] * nums[len - 2] * nums[len - 3]);
    }

    /* Solution2: Scan once
     * Find the three maximum values and two smallest values */
    public static int maximumProduct2(int[] nums) {

        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MAX_VALUE, max3 = Integer.MIN_VALUE;

        for (int num : nums) {

            if (num <= min1) {
                min2 = min1;
                min1 = num;
            } else if (num <= min2) {   // num lies between min1 and min2
                min2 = num;
            }

            if (num >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num >= max2) {
                max3 = max2;
                max2 = num;
            } else if (num >= max3) {
                max3 = num;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
