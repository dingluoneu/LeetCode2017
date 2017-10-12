package array;

public class NonDecreasingArray {

    public static boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 3) return true;

        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;

                if (i > 0 && nums[i + 1] < nums[i - 1]) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = nums[i + 1];
                }
            }
        }

        return count <= 1;
    }
}
