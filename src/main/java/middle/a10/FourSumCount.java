package middle.a10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FourSumCount {
    /**
     * 一开始使用三个for循环嵌套，用一个map来判断最后一个数组中是否含有需要的元素
     * <p>
     * 然而，一旦第四个数组中有重复的元素时，将会统计遗漏
     * <p>
     * 因此，将map改为元素对应出现次数的map
     * <p>
     * 至此，时间复杂度为O3
     * <p>
     * <p>
     * 然而，既然可以用map代替遍历最后一个数组，那么就可以用map代替最后两个数组所有和及出现的元素
     * <p>
     * 这样   时间复杂度就为O2
     *
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 此排序参考第一名答案，可能这样能更好利用内存、cpu，因此能加快运行速度
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        Arrays.sort(nums4);
        // i+j对应出现次数的map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums3) {
            for (int j : nums4) {
                int sum = i + j;
                map.merge(sum, 1, Integer::sum);
            }
        }
        int count = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                int diff = -(i + j);
                count = count + map.getOrDefault(diff, 0);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FourSumCount fourSumCount = new FourSumCount();
        int[] nums1 = {0, 1, -1};
        int[] nums2 = {-1, 1, 0};
        int[] nums3 = {0, 0, 1};
        int[] nums4 = {-1, 1, 1};
        int i = fourSumCount.fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println(i);
    }
}
