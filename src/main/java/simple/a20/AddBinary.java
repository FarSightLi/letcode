package simple.a20;

import java.math.BigInteger;

/**
 * 二进制相加
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        // 计算需要补零的个数
        int padding = Math.abs(a.length() - b.length());
        // 补零到相同长度
        if (a.length() < b.length()) {
            a = addZeros(a, padding);
        } else if (b.length() < a.length()) {
            b = addZeros(b, padding);
        }
        char[] array1 = a.toCharArray();
        char[] array2 = b.toCharArray();
        int carry = 0;
        for (int i = array1.length - 1; i >= 0; i--) {
            // == 2
            if (array1[i] + array2[i] + carry == 98) {
                carry = 1;
                array2[i] = '0';
                // == 3
            } else if (array1[i] + array2[i] + carry == 99) {
                carry = 1;
                array2[i] = '1';
                // == 1
            } else if (array1[i] + array2[i] + carry == 97) {
                carry = 0;
                array2[i] = '1';
                // == 0
            } else if (array1[i] + array2[i] + carry == 96) {
                carry = 0;
                array2[i] = '0';
            }
            if (i == 0 && carry == 1) {
                array2 = add(array2);
            }
        }
        return String.valueOf(new StringBuilder().append(array2));
    }

    private char[] add(char[] array) {
        char[] chars = new char[array.length + 1];
        chars[0] = '1';
        for (int i = 0; i < array.length; i++) {
            chars[i + 1] = array[i];
        }
        return chars;
    }

    // 补零函数
    private static String addZeros(String str, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append('0');
        }
        builder.append(str);
        return builder.toString();
    }

    /**
     * 2024.10.25新思路，使用位运算
     * @param a
     * @param b
     * @return
     */
    public String addBinaryNew(String a, String b) {
        // make a length is max
        int dif = a.length() - b.length();
        if (dif < 0) {
            String t = "";
            t = a;
            a = b;
            b = t;
        }
        // 补0
        StringBuilder zero = new StringBuilder();
        for (int i = 0; i < Math.abs(dif); i++) {
            zero.append("0");
        }
        b = zero.append(b).toString();
        char c = '0';
        char[] result = new char[a.length() + 1];
        int resultIndex = a.length();
        for (int i = b.length() - 1; i >= 0; i--) {
            char charA = a.charAt(i);
            char charB = b.charAt(i);
            char r = (charA ^ charB) == 0 ? '0' : '1';
            r = (r ^ c) == 0 ? '0' : '1';
            if ((charA == charB && charA == '1') || r == '0' && c == '1') {
                c = '1';
            }else {
                c = '0';
            }
            result[resultIndex] = r;
            resultIndex--;
        }
        if (c == '1') {
            result[resultIndex] = c;
            return String.valueOf(result,resultIndex,result.length);
        }
        return String.valueOf(result,1,result.length-1);
    }
    public static void main(String[] args) {

    }
}
