package string;

public class DetectCapital {

    public static boolean detectCapitalUse(String word) {
        word = word.trim();

        if (word == null || word.length() < 2) return true;

        String sub = word.substring(1, word.length());

        if (Character.isUpperCase(word.charAt(0))) {
            if (allUpperCase(sub) || allLowerCase(sub)) {
                return true;
            }
        }

        return allLowerCase(sub);
    }

    private static boolean allUpperCase(String s) {

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean allLowerCase(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }
}
