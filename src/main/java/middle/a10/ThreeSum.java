package middle.a10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length < 3) {
            return result;
        }
        if (length == 3){
            int sumThird = nums[0] + nums[1] + nums[2];
            if (sumThird ==0){
                result.add(Arrays.asList(nums[0], nums[1], nums[2]));
            }
            return result;
        }
        Arrays.sort(nums);
        if (nums[0]+nums[1]+nums[2] > 0) {
            return result;
        }
        if (nums[length-3]+nums[length-2]+nums[length-1] < 0) {
            return result;
        }
        for (int i = 0; i < length - 2; i++) {
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                if (i< length -2 && nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                    break;
                }
                if (nums[right - 2] + nums[right - 1] + nums[right] < 0) {
                    right--;
                    continue;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 如果i后面这些数字加上左右指针对应的数字都是0，就跳过
                    while (i < length - 2 && nums[i+1] + nums[left] + nums[right] ==0 && nums[i] == nums[i+1]){
                        i++;
                    }
                    // 左指针右移，直到左指针所值的是独特的数字
                    while (left + 1 < length && nums[left] == nums[left+1]) {
                        left++;
                    }
                    // 右指针左移，直到右指针所值的是独特的数字
                    while (right -1 > 0 && nums[right] == nums[right-1]){
                        right--;
                    }
                    right--;
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{0,0,0,0}));
//        System.out.println(threeSum.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
