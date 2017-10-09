package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /* Solution1: O(n^2) */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) return false;

        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];

                if (a == b) {
                    return true;
                }
            }
        }
        return false;
    }

    /* Solution2: Sort first
     * O(nlog(n)) */
    public boolean containsDuplicate2(int[] nums) {
        if (nums == null || nums.length < 2) return false;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /* Solution3: HashSet */
    public boolean containsDuplicate3(int[] nums) {
        if (nums == null || nums.length < 2) return false;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
