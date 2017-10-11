package array;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) return 0;

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 1, 4, 1, 5, 1};

        removeElement(nums, 1);
    }
}
