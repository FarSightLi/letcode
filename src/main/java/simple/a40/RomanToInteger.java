package simple.a40;

import java.util.HashMap;
import java.util.Map;

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
                Integer left = romanMap.get(array[i]);
                Integer right = romanMap.get(array[i + 1]);
                if (left < right) {
                    // left less than right, just decrement
                    sum -= left;
                }else {
                    // else increment
                    sum += left;
                }
            }
            // last num must bigger than left, so just decrement
            return sum + romanMap.get(array[array.length -1]);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
}
