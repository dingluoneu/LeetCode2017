package array;

import java.util.Arrays;

public class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        Arrays.sort(nums);
        int sum = 0;

        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
