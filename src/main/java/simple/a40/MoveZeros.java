package simple.a40;

public class MoveZeros {
    static class Solution {
        public void moveZeroes(int[] nums) {
            // non-zero count
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[count] = nums[i];
                    count++;
                }
            }
            // 将最后(length-count)位0补充完整
            while (count < nums.length) {
                nums[count] = 0;
                count ++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.moveZeroes(new int[]{0, 1});
    }
}
