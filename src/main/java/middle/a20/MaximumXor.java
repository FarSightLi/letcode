package middle.a20;

public class MaximumXor {
    /**
     * Note that the maximum possible XOR result is always 2^(maximumBit) - 1
     * @param nums
     * @param maximumBit
     * @return
     */
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] result = new int[nums.length];
        // 最大异或
        int maxXor = (1 << maximumBit) - 1 ;
        int p = nums.length-1;
        int prefixSum = nums[0];
        result[p] = maxXor ^ prefixSum;
        p--;
        for (int i = 1; i < nums.length; i++) {
            prefixSum = prefixSum ^ nums[i];
            result[p] = maxXor ^ prefixSum;
            p--;
        }
        return result;
    }

    public static void main(String[] args) {
        new MaximumXor().getMaximumXor(new int[]{2,3,4,7},3);
    }
}
