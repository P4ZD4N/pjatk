public class Task5 {
    public static void main(String[] args) {
        System.out.println(findMax(1,2,3));
        System.out.println(findMax(1,3,2));
        System.out.println(findMax(2,3,3));
    }
    private static int findMax(int firstNumber, int secondNumber, int thirdNumber) {
        if (firstNumber >= secondNumber && firstNumber >= thirdNumber)
            return firstNumber;
        else if (secondNumber >= firstNumber && secondNumber >= thirdNumber)
            return secondNumber;
        else
            return thirdNumber;
    }
}
