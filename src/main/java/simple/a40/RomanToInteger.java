package simple.a40;

import java.util.HashMap;

public class RomanToInteger {
    static class Solution {
        /**
         * 将map构造提出去，即可 时间83.77，空间95.93
         */
        static HashMap<Character, Integer> romanMap = new HashMap<>(7);

        static {
            romanMap.put('I', 1);
            romanMap.put('V', 5);
            romanMap.put('X', 10);
            romanMap.put('L', 50);
            romanMap.put('C', 100);
            romanMap.put('D', 500);
            romanMap.put('M', 1000);
        }

        /**
         * 时长59.89；空间70.41
         *
         * @param s
         * @return
         */
        public int romanToInt(String s) {
            char[] array = s.toCharArray();
            int sum = 0;
            for (int i = 0; i < array.length - 1; i++) {
                // adjust not out of index
                // left less than right
                Integer left = romanMap.get(array[i]);
                Integer right = romanMap.get(array[i + 1]);
                if (left < right) {
                    sum += right - left;
                    i++;
                    continue;
                }
                sum += left;
                sum += romanMap.get(array[i]);
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.romanToInt("MCMXCIV");
    }
}
