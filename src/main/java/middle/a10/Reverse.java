package middle.a10;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * <p>
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * <p>
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * <p>
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 */
public class Reverse {
    public int reverse(int x) {
        long result = 0;
        while (x!=0){
            int i = x % 10;
            result = result * 10 + i;
            x= x/10;
        }
        if (result>Integer.MAX_VALUE || result<Integer.MIN_VALUE){
            return 0;
        }
        return (int) result;
    }
    public static void main(String[] args) {
        System.out.println(new Reverse().reverse(-1121));
    }
}
