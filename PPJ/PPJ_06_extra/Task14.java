import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter price: ");
        double price = in.nextDouble();

        double[] money = new double[] {500, 200, 100, 50, 20, 10 , 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};
        int oneParticularMoneyCounter = 0;

        for (double oneParticularMoney : money) {
            while (price >= oneParticularMoney) {
                price -= oneParticularMoney;
                oneParticularMoneyCounter++;
            }
            if (oneParticularMoneyCounter > 0)
                System.out.println(oneParticularMoneyCounter + " * " + oneParticularMoney + " zl");
            oneParticularMoneyCounter = 0;
        }
    }
}