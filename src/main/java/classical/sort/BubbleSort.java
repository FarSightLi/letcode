package classical.sort;

public class BubbleSort {
    /**
     * 非传统冒泡，将最大数放到末尾
     *
     * @param nums
     */
    public void bubbleSort1(int[] nums) {
        int count = 0;
        int max = 0;
        int p = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            count++;
            if (nums[i] >= max) {
                max = nums[i];
                p = i;
            }
            if (i == length - 1) {
                length--;
                // 交换变量
                int temp = nums[i];
                nums[i] = max;
                nums[p] = temp;
                // 初始化各指针
                max = 0;
                p = 0;
                i = -1;
            }
        }
        System.out.println("冒泡1：" + count);
    }

    /**
     * 传统冒泡排序(理解有误)
     *
     * @param nums
     */
    public void bubbleSort2(int[] nums) {
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            count++;
            if (nums[i] > nums[i + 1]) {
                nums[i + 1] = nums[i + 1] ^ nums[i] ^ (nums[i] = nums[i + 1]);
            }
            if (i == length - 2) {
                length--;
                i = -1;
            }
        }
        System.out.println("冒泡2：" + count);
    }

    /**
     * 真正冒泡，自己写
     *
     * @param nums
     */
    public void bubbleSort4(int[] nums) {
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                count++;
                if (nums[j]>nums[j+1]){
                    nums[j + 1] = nums[j + 1] ^ nums[j] ^ (nums[j] = nums[j + 1]);
                }
            }
        }
        System.out.println("冒泡4：" + count);
    }

    /**
     * GPT的冒泡（真正的冒泡）
     *
     * @param nums
     */
    public void bubbleSort3(int[] nums) {
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                count++;
                if (nums[j] > nums[j + 1]) {
                    // 基本操作：比较和交换
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        System.out.println("冒泡3：" + count);
    }


    public static void main(String[] args) {
        int[] ints = {9, 4, 6, 8, 3, 10, 4, 6};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort1(ints);
        for (int anInt : ints) {
            System.out.printf(anInt + ",");
        }
        System.out.println();
        int[] ints2 = {9, 4, 6, 8, 3, 10, 4, 6};
        bubbleSort.bubbleSort2(ints2);
        for (int anInt : ints2) {
            System.out.printf(anInt + ",");
        }
        System.out.println();
        int[] ints3 = {9, 4, 6, 8, 3, 10, 4, 6};
        bubbleSort.bubbleSort3(ints3);
        for (int anInt : ints3) {
            System.out.printf(anInt + ",");
        }
        System.out.println();
        int[] ints4 = {9, 4, 6, 8, 3, 10, 4, 6};
        bubbleSort.bubbleSort4(ints4);
        for (int anInt : ints4) {
            System.out.printf(anInt + ",");
        }
    }
}
