package array;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[] {1};
        }

        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int value = digits[i];
            int sum = value + carry;

            if (sum > 9) {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] = sum;
                carry = 0;
            }
        }

        if (carry == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
