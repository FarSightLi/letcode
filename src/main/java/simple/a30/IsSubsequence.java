package simple.a30;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 100
 * <p>
 * 0 <= t.length <= 10^4
 * <p>
 * 两个字符串都只由小写字符组成。
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        int sPoint = 0;
        int tPoint = 0;
        while (tPoint < tchar.length && sPoint < schar.length) {
            if (schar[sPoint] == tchar[tPoint]) {
                sPoint++;
                tPoint++;
                continue;
            }
            tPoint++;
        }
        return sPoint==schar.length && tPoint<=tchar.length;
    }

    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("abc","afdbdc"));
    }
}
