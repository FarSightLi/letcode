package test;

public class ArrayHasNum {
    public boolean solution(int[][] nums,int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int a = nums[i][j];
                if (a > target){
                    // 说明这一行没有目标
                    break;
                }else if (a == target){
                    return true;
                }
            }
        }
        // 全部循环完都没有找到，说明false
        return false;
    }

    public static void main(String[] args) {
        int[][] ints = new int[3][3];
        ints[0][0] = 1;
        ints[0][1] = 2;
        ints[0][2] = 3;
        ints[1][0] = 4;
        ints[1][1] = 5;
        ints[1][2] = 6;
        ints[2][0] = 7;
        ints[2][1] = 8;
        ints[2][2] = 9;
        System.out.println(new ArrayHasNum().solution(ints, 11));
    }
}
