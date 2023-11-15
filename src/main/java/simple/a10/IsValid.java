package simple.a10;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                continue;
            }
            // 字符串已经没有左括号只有右括号，那肯定不符合
            if (stack.empty()) {
                return false;
            }
            if (s.charAt(i) == '}'){
                if (stack.peek() != '{'){
                    return false;
                }else {
                    stack.pop();
                    continue;
                }
            }
            if (s.charAt(i) == ']'){
                if (stack.peek() != '['){
                    return false;
                }else {
                    stack.pop();
                    continue;
                }
            }
            if (s.charAt(i) == ')'){
                if (stack.peek() != '('){
                    return false;
                }else {
                    stack.pop();
                    continue;
                }
            }
            stack.push(s.charAt(i));

        }
        return stack.empty();
    }


    public static void main(String[] args) {
        System.out.println(new IsValid().isValid("(})"));
    }

//    public boolean isValid(String s) {
//        char[] chars = s.toCharArray();
//        if (chars.length <= 1 || chars.length % 2 != 0) {
//            return false;
//        }
//        LinkedList<Character> characters = new LinkedList<>();
//        for (char aChar : chars) {
//            characters.add(aChar);
//        }
//        for (int i = 1; i < characters.size(); i++) {
//            Character c1 = characters.get(i);
//            Character c2 = characters.get(i - 1);
//            if (c1.equals(')') && c2.equals('(')) {
//                characters.remove(i);
//                characters.remove(i - 1);
//                if (i>=2){
//                    i=i-2;
//                }else {
//                    i--;
//                }
//            }
//            if (c1.equals('}') && c2.equals('{')) {
//                characters.remove(i);
//                characters.remove(i - 1);
//                if (i>=2){
//                    i=i-2;
//                }else {
//                    i--;
//                }
//            }
//            if (c1.equals(']') && c2.equals('[')) {
//                characters.remove(i);
//                characters.remove(i - 1);
//                if (i>=2){
//                    i=i-2;
//                }else {
//                    i--;
//                }
//            }
//        }
//        return characters.size() == 0;
//    }
}
