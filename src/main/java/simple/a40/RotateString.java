package simple.a40;

public class RotateString {
    /**
     * 递归，顺着转移，效率太低
     *
     * @param s
     * @param goal
     * @return
     */
    public boolean rotateStringOld(String s, String goal) {
        int maxCount = s.length();
        if (maxCount == 1 && s.equals(goal)) {
            return true;
        }
        return recursion(s, goal, 0, maxCount);
    }

    private boolean recursion(String s, String goal, int count, int maxCount) {
        if (count >= maxCount) {
            return false;
        }
        count++;
        char[] chars = new char[maxCount];
        // make right to first
        chars[0] = s.charAt(maxCount - 1);
        for (int i = 1; i < maxCount; i++) {
            chars[i] = s.charAt(i - 1);
        }
        String rotated = String.valueOf(chars);
        if (rotated.equals(goal)) {
            return true;
        }
        return recursion(rotated, goal, count, maxCount);
    }


    /**
     * 将从左移到最右理解为 将最左依次移到最右 -> 则相当于直接将整个字符串拼到最后
     * <p>
     * 然后再判断是否有包含关系
     *
     * @param s
     * @param goal
     * @return
     */
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        String a = s + s;
        return a.contains(goal);
    }

    public static void main(String[] args) {
        System.out.println(new RotateString().rotateString("abcde", "cdeab"));
    }
}
