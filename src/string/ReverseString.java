package string;

public class ReverseString {
    /* Solution1: StringBuilder
     * 7ms, 7.08% */
    public static String reverseString(String s) {
        if (s == null || s.length() < 2) return s;

        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            sb.append(c);
        }
        return sb.toString();
    }

    /* Solution2:
     * 3 ms, 47.25% */
    public static String reverseString2(String s) {
        if (s == null || s.length() < 2) return s;

        char[] charArr = s.toCharArray();
        int left = 0;
        int right =charArr.length - 1;

        while (left < right) {
            char temp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = temp;

            left++;
            right--;
        }
        return String.valueOf(charArr);
    }
}
