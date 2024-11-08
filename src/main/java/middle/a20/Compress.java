package middle.a20;


public class Compress {
    public int compress(char[] chars) {
        int count = 1;
        int p = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                // 和上一个字母不同
                if (count > 1) {
                    // 填充count
                    String strCount = String.valueOf(count);
                    for (int j = 0; j < strCount.length(); j++) {
                        chars[p] = strCount.charAt(j);
                        p++;
                    }
                }
                // 填充当前这个不同的字母
                chars[p] = chars[i];
                p++;
                count=1;
            }
        }
        if (count > 1) {
            String strCount = String.valueOf(count);
            for (int j = 0; j < strCount.length(); j++) {
                chars[p] = strCount.charAt(j);
                p++;
            }
        }
        return p;
    }

    public static void main(String[] args) {
//        System.out.println(new Compress().compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(new Compress().compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b','b','c','d','d'}));
    }
}
