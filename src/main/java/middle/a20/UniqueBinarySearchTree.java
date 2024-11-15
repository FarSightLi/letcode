package middle.a20;

public class UniqueBinarySearchTree {
    static int[] table;

    public int numTrees(int n) {
        table = new int[n];
        return countTree(1,n);
    }

    public int countTree(int start, int end) {
        int result = 0;
        int diff = end - start;
        if (diff < 0) {
            diff = 0;
        }
        int count = table[diff];
        if (count!=0) {
            return count;
        }
        if (diff < 2) {
            table[diff] = diff+1;
            return diff + 1;
        } else if (diff == 2) {
            table[diff] = 5;
            return 5;
        }
        for (int i = start; i <= end; i++) {
            result = result + (countTree(start, i - 1) * countTree(i + 1, end));
        }
        table[diff] = result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTree().numTrees(19));
    }
}
