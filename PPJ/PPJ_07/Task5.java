public class Task5 {
    public static void main(String[] args) {
        double[] doubleArray = new double[10];

        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = Math.random() * 10;
            System.out.print(doubleArray[i] + " ");
        }

        System.out.println("");

        for (int i = 0; i < doubleArray.length; i++)
            if (i % 2 == 0)
                System.out.print(doubleArray[i] + " ");

        System.out.println("");

        for (int i = 0; i < doubleArray.length; i++)
            if ((int) doubleArray[i] % 2 != 0)
                System.out.print(doubleArray[i] + " ");
    }
}
