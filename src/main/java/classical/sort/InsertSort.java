package classical.sort;

public class InsertSort {
    public void insertSort(int[] nums){
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            int p = 0;
            // 寻找插入的位置
            for (int j = 0; j < i; j++) {
                // 说明要插在前面
                if (nums[j] < nums[i]){
                     p = j;
                    break;
                }
            }
            // 开始插入
        }
    }

    public static void main(String[] args) {

    }
}
