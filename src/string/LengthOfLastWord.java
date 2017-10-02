package string;

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        if (s == null || s.length() == 0) return 0;

        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (!Character.isWhitespace(c)) {
                len++;
            }

            if (Character.isWhitespace(c)) {
                break;
            }
        }
        return len;
    }
}
