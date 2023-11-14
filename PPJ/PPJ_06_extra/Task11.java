public class Task11 {
    public static void main(String[] args) {
        int deg = (int) (Math.random() * 360);

        if (deg == 0) {
            System.out.println(deg + "° North");
        } else if (deg >= 1 && 89 >= deg) {
            System.out.println(deg + "° North east");
        } else if (deg == 90) {
            System.out.println(deg + "° East");
        } else if (deg >= 91 && 179 >= deg) {
            System.out.println(deg + "° South east");
        } else if (deg == 180) {
            System.out.println(deg + "° South");
        } else if (deg >= 181 && 269 >= deg) {
            System.out.println(deg + "° South west");
        } else if (deg == 270) {
            System.out.println(deg + "° West");
        } else if (deg >= 271 && 359 >= deg) {
            System.out.println(deg + "° North west");
        }
    }
}