package array;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

    /* Solution1: Bottom-up */
    public static int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0) return -1;

        int[] total = new int[triangle.size()];
        int lastLevel = triangle.size() - 1;

        for (int i = 0; i < triangle.get(lastLevel).size(); i++) {
            total[i] = triangle.get(lastLevel).get(i);
        }

        /* Iterate from last second row */
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
                total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
            }
        }
        return total[0];
    }

}
