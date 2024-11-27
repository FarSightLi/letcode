package simple.a50;

public class DefuseTheBomb {
    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        int length = code.length;
        for (int i = 0; i < code.length; i++) {
            int target = 0;
            if (k < 0) {
                // replace the ith number with the sum of the previous k numbers.
                for (int j = i - 1; j > i - 1 + k; j--) {
                    int index = (length + j) % length;
                    target += code[index];
                }
            } else if (k > 0) {
                for (int j = i + 1; j < i + 1 + k; j++) {
                    int index = j % length;
                    target += code[index];
                }
            }
            result[i] = target;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] decrypt = new DefuseTheBomb().decrypt(new int[]{2, 4, 9, 3}, -2);
        for (int i : decrypt) {
            System.out.print(i + " ");
        }
    }
}
