package simple.a10;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        // 找到最短的字符串的长度，以免数组越界
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        char[][] chars = new char[strs.length][minLength];

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            for (int j = 0; j < minLength; j++) {
                char c = str.charAt(j);
                chars[i][j] = c;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int j = 0; j < minLength; j++) {
            char commonChar = chars[0][j];
            for (int i = 0; i < strs.length; i++) {
                if (chars[i][j] != commonChar) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(commonChar);
        }

        return stringBuilder.toString();
    }

    public String longestCommonPrefixByGPT(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefixHelper(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefixHelper(String[] strs, int left, int right) {
        // Base case: if the range is a single string
        if (left == right) {
            return strs[left];
        }

        // Split the array into halves
        int mid = left + (right - left) / 2;

        // Recursively find the longest common prefix in both halves
        String leftPrefix = longestCommonPrefixHelper(strs, left, mid);
        String rightPrefix = longestCommonPrefixHelper(strs, mid + 1, right);

        // Merge the two prefixes
        return commonPrefix(leftPrefix, rightPrefix);
    }

    private String commonPrefix(String left, String right) {
        int minLength = Math.min(left.length(), right.length());
        for (int i = 0; i < minLength; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, minLength); // One is a prefix of the other
    }


    public static void main(String[] args) {
        String[] strings = {"flower", "flower", "flower", "flower"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefixByGPT(strings));
    }
}
