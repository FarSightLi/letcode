package middle.a20;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();
        String[] split = path.split("/");
        for (String s : split) {
            if (s.isEmpty()) {
                continue;
            }
            if (s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                String peek = deque.peek();
                if (peek == null || "/".equals(peek)) {
                    continue;
                }
                deque.pop();
                continue;
            }
            deque.push(s);
        }
        if (deque.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            String last = deque.pollLast();
            if (!last.equals("/")) {
                sb.append("/");
            }
            sb.append(last);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/home/user/Documents/../Pictures"));
    }
}
