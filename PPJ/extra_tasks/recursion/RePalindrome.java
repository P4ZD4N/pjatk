public class RePalindrome {
    private static int index = 0;
    private static boolean wasMethodPerformed = false;

    public static boolean isPalindrome(String word) {
        if (wasMethodPerformed) {
            index = 0;
            wasMethodPerformed = false;
        }

        word = word.toLowerCase();
        int wordLength = word.length();

        if (index == wordLength - 1) {
            wasMethodPerformed = true;
            return word.charAt(index) == word.charAt(wordLength - 1 - index);
        }

        if (word.charAt(index) == word.charAt(wordLength - 1 - index)) {
            index++;
            return isPalindrome(word);
        } else
            return false;
    }
}
