package simple.a10;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 */
public class Search {
    public int search(int[] nums, int target) {
        int mid = nums.length/2;
        if (nums[mid] > target){
            for (int i = 0; i < mid; i++) {
                if (nums[i]==target){
                    return i;
                }
            }
        }else {
            for (int i = mid; i < nums.length; i++) {
                if (nums[i]==target){
                    return i;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new Search().search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }
}
