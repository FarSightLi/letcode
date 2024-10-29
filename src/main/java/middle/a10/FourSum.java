package middle.a10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 4) {
            return result;
        }
        for (int i = 0; i < nums.length - 3; i++) {
            // 去重，逻辑是，假如之前(i-1时)已经找到一组数据，那么i时必然也能找到一组相同的数据，就重复了
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 继续往下找
                        while (left< right && nums[right] == nums[right-1]) right--;
                        while (left< right && nums[left] == nums[left+1]) left++;
                        right--;
                        left++;
                    } else if (sum > target) {
                        right--;
                    }else {
                        left++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
