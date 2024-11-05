package middle.a20;

public class CompressedString {
    public String compressedString(String word) {
        char c = word.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < word.length(); i++) {
            char now = word.charAt(i);
            if (c == now) {
                count++;
                if (count > 9) {
                    sb.append(9).append(c);
                    count -= 9;
                }
            }else {
                // 已经是不同的字母
                sb.append(count).append(c);
                c = now;
                count = 1;
            }
        }
        sb.append(count).append(c);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CompressedString().compressedString("aaaaaaaaay"));
    }
}
