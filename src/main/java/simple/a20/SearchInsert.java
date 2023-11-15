package simple.a20;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * <p>
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * <p>
 * -104 <= nums[i] <= 104
 * <p>
 * nums 为 无重复元素 的 升序 排列数组
 * <p>
 * -104 <= target <= 104
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if (nums[0]> target){
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (i == nums.length - 1) {
                if (nums[i]<=target){
                    return nums.length;
                }else {
                    return i;
                }
            }
            if (nums[i] < target && nums[i + 1] >= target) {
                return i + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] ints = {1, 3, 5, 6};
        System.out.println(new SearchInsert().searchInsert(ints, 0));
    }
}
