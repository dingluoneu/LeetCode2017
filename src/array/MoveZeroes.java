package array;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) return;

        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 0, 0, 2, 12};
        moveZeroes(nums);
    }
}
