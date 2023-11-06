public class Task4 {
    public static void main(String[] args) {
        int day = 28;
        int month = 10;

        int daysSince1stJan = 0;

        for (int i = 1; i <= month; i++) {
            switch (i) {
                case 1,3,5,7,8,10,12 -> {
                    for (int j = 1; j <= 31; j++) {
                        daysSince1stJan++;
                        if (i == month && j == day) {
                            break;
                        }
                    }
                }
                case 4,6,9,11 -> {
                    for (int j = 1; j <= 30; j++) {
                        daysSince1stJan++;
                        if (i == month && j == day) {
                            break;
                        }
                    }
                }
                case 2 -> {
                    for (int j = 1; j <= 28; j++) {
                        daysSince1stJan++;
                        if (i == month && j == day) {
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("Days since 1st january: " + daysSince1stJan);
        System.out.println("Days to 31 december: " + (365 - daysSince1stJan));
    }
}