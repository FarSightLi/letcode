package middle.a10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int k = nums.length - j - 1;
                int first = nums[i];
                int second = nums[j];
                int third = nums[i + 1];
                int fourth = nums[k];
                if (target == first+second+third+fourth) {
                    List<Integer> r = new ArrayList<>(4);
                    result.add(r);
                }
            }
        }
        return result;
    }
}
