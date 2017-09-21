package string;

public class JudgeRouteCircle {

    public static boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) return true;

        /**
         *    index:     0                1
         *    direction: horizontal    vertical
         *
         *    Traversal the 'moves' string:
         *    if 'UP', directions[1]--;
         *    if 'DOWN', directions[1]++;
         *    if 'LEFT', directions[0]--;
         *    if 'RIGHT', directions[0]++;
         *
         *    Finally, check the 'directions' array, if any of the lements is not 0, return false, otherwise, return true
         */
        int[] directions = new int[2];

        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'U') {
                directions[1]--;
            } else if (c == 'D') {
                directions[1]++;
            } else if (c == 'L') {
                directions[0]--;
            } else if (c == 'R') {
                directions[0]++;
            }
        }

        for (int i = 0; i < directions.length; i++) {
            if (directions[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
