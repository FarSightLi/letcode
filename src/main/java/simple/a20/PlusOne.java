package simple.a20;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * <p>
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 100
 * <p>
 * 0 <= digits[i] <= 9
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        digits[length - 1]++;
        int p = length - 1;
        // 需要进位
        while (digits[p] >= 10 && p>=0){
            digits[p] = 0;
            if (p == 0){
                int[] ints = new int[length + 1];
                ints[0] = 1;
                for (int i = 0; i < digits.length; i++) {
                    ints[i+1] = digits[i];
                }
                return ints;
            }
            digits[p-1]++;
            p--;
        }
        return digits;
    }

    /**
     * 2024.10.26新解法，时间击败100%
     */
    class Solution {
        public int[] plusOne(int[] digits) {
            int carry = 0;
            int lastNum = digits[digits.length - 1] + 1;
            if (lastNum >= 10) {
                lastNum = lastNum - 10;
                carry = 1;
            }
            digits[digits.length - 1] = lastNum;
            for (int i = digits.length - 2; i >= 0; i--) {
                int r = digits[i] + carry;
                if (r >= 10) {
                    carry = 1;
                    r = r - 10;
                }else {
                    carry = 0;
                }
                digits[i] = r;
            }
            if (carry > 0) {
                int[] result = new int[digits.length + 1];
                result[0] = carry;
                System.arraycopy(digits, 0, result, 1, digits.length);
                return result;
            } else {
                return digits;
            }
        }
    }

}
