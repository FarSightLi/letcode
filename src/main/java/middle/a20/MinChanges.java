package middle.a20;

public class MinChanges {
    public int minChanges(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i=i+2) {
            if (s.charAt(i) != s.charAt(i+1)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new MinChanges().minChanges("010010"));
    }
}
