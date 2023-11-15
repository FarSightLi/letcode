package simple.a10;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 * <p>
 * <p>
 * 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        if (n == 0) {
//            return;
//        }
//        for (int i = 0; i < nums2.length; i++) {
//            nums1[m + i] = nums2[i];
//        }
//        if (m == 0) {
//            return;
//        }
        // 此时两数组已经合并，下面进行排序
        // 冒泡排序
//        for (int j = 0; j < nums1.length -1; j++) {
//            int point = 0;
//            for (int i = 0; i < nums1.length-1; i++) {
//                int temporary = 0;
//                if (nums1[point] >= nums1[point + 1]) {
//                    temporary = nums1[point];
//                    nums1[point] = nums1[point + 1];
//                    nums1[point + 1] = temporary;
//                }
//                point++;
//            }
//        }
//        int p1 = 0, p2 = 0;
//        int p = p1 + p2;
//        int[] ints = new int[m + n];
//        // 当nums1或nums2还有元素时
//        while (p1 <= m - 1 && p2 <= n - 1) {
//            // 当1数组第一位大于2数组第一位时，添加二数组,或者p1指针已越过最后一位
//            if ((nums1[p1] > nums2[p2]) || p1==m) {
//                ints[p] = nums2[p2];
//                p++;
//                // 将二数组的指针向后挪一位
//                p2++;
//            }else {
//                // 添加一数组
//                ints[p] = nums1[p1];
//                p++;
//                p1++;
//            }
//        }
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        while (p1 >= 0 || p2 >= 0) {
            // nums1已全部添加
            if (p1 <= -1) {
                nums1[tail] = nums2[p2];
                p2--;
                tail--;
            } else if (p2 <= -1) {
                nums1[tail] = nums1[p1];
                tail--;
                p1--;
                // 数组一 >= 数组二，添加数组一
            } else if (nums1[p1] >= nums2[p2]) {
                nums1[tail] = nums1[p1];
                tail--;
                p1--;
            } else if (nums1[p1] < nums2[p2]) {
                nums1[tail] = nums2[p2];
                p2--;
                tail--;
            }
        }
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        new Merge().merge(nums1, m, nums2, n);
    }
}
