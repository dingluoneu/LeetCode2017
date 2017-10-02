package string;

public class NumberOfSegmentsInString {

    public static int countSegments(String s) {
        s = s.trim();

        if (s == null || s.length() == 0) return 0;

        int count = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (!Character.isWhitespace(s.charAt(i)) && Character.isWhitespace(s.charAt(i + 1))) {
                count++;
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        String s = ", , , ,        a, eaefa";
        System.out.println(countSegments(s));
    }
}
