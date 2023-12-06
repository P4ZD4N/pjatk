public class Task4 {
    public static void main(String[] args) {
        int wrt = 5;
        modifyValue(wrt);
        System.out.println(wrt);
        // value of "wrt" variable is entered as an argument but not changed
        // because this value is only local variable (copy of wrt) in "modifyValue" method
        // and that's why this method don't have impact onto value of wrt in "main" method
    }
    private static void modifyValue(int val) {
        System.out.println(val);
        val *= 5;
        System.out.println(val);
    }
}
