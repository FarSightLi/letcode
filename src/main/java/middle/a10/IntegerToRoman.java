package middle.a10;

public class IntegerToRoman {
    static int[] n;
    static String[] s;
    static {
        n = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        s = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    }
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num - n[i] >= 0) {
                result.append(s[i]);
                num = num - n[i];
            }else {
                i++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman(3954));
    }
}
