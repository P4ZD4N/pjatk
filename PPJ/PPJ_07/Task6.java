public class Task6 {
    public static void main(String[] args) {
        int[] tab = {1,2,3,4,4,3,2,1};
        boolean isPalindrome = true;

        int i = 0;
        while (isPalindrome && i != tab.length - 1) {
            if (tab[i] != tab[tab.length - 1 - i])
                isPalindrome = false;
            i++;
        }

        System.out.println(isPalindrome);
    }
}
