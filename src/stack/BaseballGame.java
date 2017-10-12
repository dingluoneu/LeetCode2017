package stack;

import java.util.Stack;

public class BaseballGame {

    public static int callPoints(String[] ops) {

        if (ops == null || ops.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int finalScore = 0;

        for (String record : ops) {

            if (!record.equals("C") && !record.equals("D") && !record.equals("+")) {
                int currentScore = Integer.valueOf(record);
                stack.push(currentScore);
                finalScore += currentScore;
            } else if (record.equals("+")) {
                int lastOne = 0;
                int lastTwo = 0;
                if (!stack.empty()) {
                    lastOne = stack.pop();
                }
                if (!stack.empty()) {
                    lastTwo = stack.pop();
                }
                int currentScore = lastOne + lastTwo;
                stack.push(lastTwo);
                stack.push(lastOne);
                stack.push(currentScore);
                finalScore += currentScore;
            } else if (record.equals("D")) {
                int lastOne;
                if (!stack.empty()) {
                    lastOne = stack.peek();
                    int currentScore = 2 * lastOne;
                    stack.push(currentScore);
                    finalScore += currentScore;
                }
            } else if (record.equals("C")) {
                int lastOne = 0;
                if (!stack.empty()) {
                    lastOne = stack.pop();
                    finalScore -= lastOne;
                }
            }
        }
        return finalScore;
    }
}
