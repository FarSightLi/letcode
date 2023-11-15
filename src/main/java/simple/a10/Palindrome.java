package simple.a10;

//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//
//        回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
//        例如，121 是回文，而 123 不是。
public class Palindrome {
//    public boolean isPalindrome(int x) {
//        Long longX = new Long(x);
//        if (longX < 0){
//            return false;
//        }
//        //位数
//        int size = 1;
//        // 用于辅助计算位数的
//        long sizeNum = 1L;
//        while (longX / sizeNum >= 10) {
//            size++;
//            sizeNum = sizeNum * 10;
//        }
//        for (int i = 1; i <= size; i++) {
//            int leftIndicator = i;
//            int rightIndicator = size + 1 - i;
//            // 如果左边等于右边，符合标准，如果不符合就直接返回false了
//            if (getNum(longX, leftIndicator) != getNum(longX, rightIndicator)) {
//                return false;
//            }
//            // 如果右指针-左指针<=1,说明指针相遇
//            if (rightIndicator - leftIndicator<=1) {
//                return true;
//            }
//        }
//        return true;
//    }
//
//    /**
//     * @param longX 所求数字
//     * @param i   所求位数
//     * @return
//     */
//    private Long getNum(Long longX, int i) {
//        // 被取模数
//        Long mod = 1L;
//        for (int j = 0; j < i; j++) {
//            mod = mod * 10;
//        }
//        return longX % mod / (mod / 10);
//    }

    //    public boolean isPalindrome(int x) {
//        String s = String.valueOf(x);
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            int leftIndicator = i;
//            int rightIndicator = chars.length - i - 1;
//            if (chars[leftIndicator] != chars[rightIndicator]) {
//                return false;
//            }
//            if (rightIndicator - leftIndicator <= 1) {
//                return true;
//            }
//        }
//        return true;
//    }
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        int result = 0;
        int old = x;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result == old;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        boolean palindrome1 = palindrome.isPalindrome(121);
        System.out.println(palindrome1);
    }


}
