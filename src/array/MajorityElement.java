package array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    /* HashMap */
    public int majorityElement(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int key : map.keySet()) {
            if (map.get(key) > n / 2) {
                return key;
            }
        }
        throw new IllegalArgumentException();
    }

    /* Solution2 */
    public static int majorityElement2(int[] nums) {
        int major = nums[0], count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                major = nums[i];
            } else if (major == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 4, 2, 4, 4, 2, 2};
        majorityElement2(nums);
    }
}
