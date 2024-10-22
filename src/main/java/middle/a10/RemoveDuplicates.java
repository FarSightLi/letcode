package middle.a10;

import java.util.HashMap;

public class RemoveDuplicates {
    static class Solution {
        public int removeDuplicates(int[] nums) {
            int count = 2;
            for (int i = 2; i < nums.length; i++) {
                if (nums[i] != nums[count-2]) {
                    nums[count] = nums[i];
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.removeDuplicates(new int[]{1,1,1,2,2,3});
        System.out.println(i);
    }
}
