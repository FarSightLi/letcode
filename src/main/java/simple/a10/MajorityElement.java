package simple.a10;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * <p>
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题
 */
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{2, 2, 1, 1, 1, 3,3,3,3,3}));
    }
//    public int majorityElement(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            // 如果不存在，就加入
//            map.merge(num, 1, Integer::sum);
//        }
//        // 所求的元素
//        int key = 0;
//        // 出现次数
//        int time = 0;
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue()>time){
//                key = entry.getKey();
//                time = entry.getValue();
//            }
//        }
//        return key;
//    }
    public int majorityElement(int[] nums){
        //候选元素
        int a = nums[0];
        // 计数器
        int count = 1;
        for (int num : nums) {
            if (num == a) {
                count++;
            }else {
                count--;
            }
            if (count == 0){
                count = 1;
                a = num;
            }
        }
        return a;
    }
}
