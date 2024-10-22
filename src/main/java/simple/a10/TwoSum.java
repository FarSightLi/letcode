package simple.a10;

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值target的那两个整数，并返回它们的数组下标。
//
//你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//
//你可以按任意顺序返回答案。
//
//
//
//        示例 1：
//
//        输入：nums = [2,7,11,15], target = 9
//        输出：[0,1]
//        解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//        示例 2：
//
//        输入：nums = [3,2,4], target = 6
//        输出：[1,2]
//        示例 3：
//
//        输入：nums = [3,3], target = 6
//        输出：[0,1]

import java.util.HashMap;
import java.util.Map;

//时间
//
//55ms
//击败 21.18%使用 Java 的用户
//内存
//
//41.25MB
//击败 96.18%使用 Java 的用户
public class TwoSum {
        public int[] twoSum0(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 第二遍
     * 时间4ms，63.10%，内存93.44
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer t = map.get(target - nums[i]);
            if (t != null) {
                if (t.equals(nums[i])) {
                    continue;
                }
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return new int[0];
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer p = map.get(target - nums[i]);
            if (p != null){
                return new int[]{p, i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
/// chatGPT
//时间
//
//1ms
//击败 98.51%使用 Java 的用户
//内存
//
//41.42MB
//击败 80.83%使用 Java 的用户

    //public int[] twoSum(int[] nums, int target) {
//    int[] result = new int[2];
//        // 创建一个哈希表，用于存储数字和其下标的映射关系
//        HashMap<Integer, Integer> numToIndex = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i]; // 计算当前数字的补数
//            // 如果补数已经在哈希表中，说明找到了答案
//            if (numToIndex.containsKey(complement)) {
//                result[0] = numToIndex.get(complement); // 补数对应的下标
//                result[1] = i; // 当前数字的下标
//                return result;
//            }
//            // 将当前数字和下标存入哈希表
//            numToIndex.put(nums[i], i);
//        }
//    return result;
//}
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        TwoSum twoSum = new TwoSum();
        twoSum.twoSum(nums, 6);
    }
}
