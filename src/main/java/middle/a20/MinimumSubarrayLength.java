package middle.a20;

import java.util.Arrays;

public class MinimumSubarrayLength {
    public int minimumSubarrayLength(int[] nums, int k) {
//        Arrays.sort(nums);
        int length = nums.length;
        int endNum = nums[length - 1];
        if (endNum > k) {
            return 1;
        }
        int orResult = endNum;
        for (int i = length - 2; i >= 0; i--) {
            orResult = orResult | nums[i];
            if (orResult >= k ){
                return length - i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumSubarrayLength().minimumSubarrayLength(new int[]{2,1,8}, 10));
    }
}
