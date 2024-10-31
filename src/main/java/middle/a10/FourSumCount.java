package middle.a10;

import java.util.*;
import java.util.stream.Collectors;

public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int length = nums1.length;
        // 数字对应索引的map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums4.length; i++) {
            map.put(nums4[i], i);
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < length; k++) {
                    int diff = -(nums1[i] + nums2[j] + nums3[k]);
                    if (map.containsKey(diff)) {
                        count++;
                    }
                }
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
