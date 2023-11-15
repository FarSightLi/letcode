package simple.a30;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left<=right){
            if (!Character.isLetterOrDigit(chars[left])){
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(chars[right])){
                right--;
                continue;
            }
            if (chars[left] != chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
