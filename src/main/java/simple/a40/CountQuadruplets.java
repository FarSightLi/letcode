package simple.a40;

import java.util.HashMap;


/**
 * 理解不了核心思想
 */
public class CountQuadruplets {
    public int countQuadruplets(int[] nums) {
        int count = 0;
        // a+b的和 -> 组合次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < nums.length - 2; i++) {
            // 计算a+b的map
            for (int j = 0; j < nums.length; j++) {
                map.merge(i + j, 1, Integer::sum);
            }
            // 计算d-c
            for (int k = i + 2; k < nums.length; k++) {
                count = count + map.getOrDefault(nums[k] - nums[k - 1], 0);
            }
        }
        return count;
    }

    public int countQuadrupletsAn(int[] nums) {
        int[] ints = new int[201];
        int count = 0;

        for (int i = 1; i < nums.length - 2; i++) {
            for (int j = 0; j < i; j++) {
                int sum = nums[i] + nums[j];
                ints[sum]++;
            }
            for (int j = i + 2; j < nums.length; j++) {
                int diff = nums[j] - nums[i + 1];
                if (diff > -1) {
                    count += ints[diff];
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountQuadruplets countQuadruplets = new CountQuadruplets();
        System.out.println(countQuadruplets.countQuadruplets(new int[]{1, 1, 1, 3, 5}));
    }
}
