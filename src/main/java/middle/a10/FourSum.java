package middle.a10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        if (length < 4) {
            return result;
        }
        // 最小的四个加起来都比target大，说明绝无可能
        if ((long)nums[0]+nums[1]+nums[2]+nums[3] > target){
            return result;
        }
        // 最大的四个加起来都比target小，说明绝无可能
        if ((long)nums[length-4]+nums[length-3]+nums[length-2]+nums[length-1] < target){
            return result;
        }
        for (int i = 0; i < length - 3; i++) {
            // 去重，逻辑是，假如之前(i-1时)已经找到一组数据，那么i时必然也能找到一组相同的数据，就重复了
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = length - 1;
                // 在内循环中，如果最小的四个都比target大,那么说明此次循环可以结束了
                // 这里不能之间return，因为可能下一次外层i循环时，还能找到可以组合的数据
                if ((long)nums[i]+nums[j]+nums[left]+nums[left+1] > target){
                    break;
                }
                // 此循环中，如果右边两个加左边两个比target小，说明第二层循环的j小了，直接进下一个循环
                if ((long)nums[i]+nums[j]+nums[right-1]+nums[right] < target){
                    continue;
                }
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
//        System.out.println(fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSum.fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0));
    }
}
