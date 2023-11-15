package simple;

public class Demo {
    public int get(int[] nums) {
        int n = nums.length;

        // 第一次遍历，将大于0的元素放置到正确的位置
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        // 第二次遍历，查找第一个不在正确位置上的元素
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 如果数组中都在正确位置上，返回n+1
        return n + 1;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        int[] ints = new int[]{5,7,-11,9,8,1};
//        int[] ints = new int[]{1, 2, 3, 4, 5};
        System.out.println(demo.get(ints));
    }
}
