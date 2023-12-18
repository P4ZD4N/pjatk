public class Exercise2 {
    public static boolean isPalindrome(String text, int count) {
        System.out.println(count);
        System.out.println(text.length() - 1 - count);
        if (count < text.length() / 2) {
            if (text.charAt(count) != text.charAt(text.length() - 1 - count))
                return false;
            return isPalindrome(text, count + 1);
        }
        return true;
    }
}


