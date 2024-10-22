package simple.a40;

import java.util.HashMap;
import java.util.Map;

public class SingleNum {
    static class Solution {
        public int singleNumber(int[] nums) {
            int r = 0;
            for (int num : nums) {
                r = num^r;
            }
            return r;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.singleNumber(new int[]{2,2,1});
        }
    }
}
