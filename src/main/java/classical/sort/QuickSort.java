package classical.sort;

public class QuickSort {
    static int count = 0;
    public void quickSort(int[] nums, int low, int high) {
        if (low>= high){
            return;
        }
        int basic = nums[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (i < j && nums[j] >= basic) {
                count++;
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] <= basic) {
                count++;
                i++;
            }
            if (i<j){
                nums[j--] = nums[i];
            }
            nums[i] = basic;
            quickSort(nums,low,i-1);
            quickSort(nums,i+1,high);
        }
    }

    public static void main(String[] args) {
        int[] ints = {9, 4, 6, 8, 3, 10, 4, 6};
        new QuickSort().quickSort(ints, 0, ints.length - 1);
        for (int anInt : ints) {
            System.out.printf(anInt+",");
        }
        System.out.println("运行了"+count);
    }
}
