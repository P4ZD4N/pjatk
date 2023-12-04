public class Task3 {
    public static void main(String[] args) {
        String[][] arr = {
                {"Niemcy","2","Szkocja","1"},
                {"Polska","2","Niemcy","0"},
                {"Niemcy","1","Irlandia","1"},
                {"Polska","2","Szkocja","2"},
                {"Szkocja","1","Irlandia","0"},
                {"Irlandia","1","Polska","1"},
                {"Irlandia","1","Szkocja","1"},
                {"Niemcy","3","Polska","1"},
                {"Szkocja","2","Niemcy","3"},
                {"Irlandia","1","Niemcy","0"},
                {"Szkocja","2","Polska","2"},
                {"Polska","2","Irlandia","1"}
        };
        int[] winners = predictWinners(arr); // In winners array: 0 - first team is winner, 2 - second team is winner, 4 - draw
        int[] scores = calculateScores(winners, arr);

        for (int score : scores) {
            System.out.println(score);
        }
    }
    private static int[] predictWinners(String[][] arr) {
        int[] winners = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (Integer.parseInt(arr[i][1]) > Integer.parseInt(arr[i][3])) {
                winners[i] = 0;
            } else if (Integer.parseInt(arr[i][1]) == Integer.parseInt(arr[i][3])) {
                winners[i] = 4;
            } else {
                winners[i] = 2;
            }
        }
        return winners;
    }

    private static int[] calculateScores(int[] winners, String[][] arr) {
        int[] scores = new int[4];
        for (int i = 0; i < arr.length; i++) {
            switch (winners[i]) {
                case 0 -> {
                    switch (arr[i][0]) {
                        case "Niemcy" -> scores[0] += 3;
                        case "Irlandia" -> scores[1] += 3;
                        case "Polska" -> scores[2] += 3;
                        case "Szkocja" -> scores[3] += 3;
                    }
                }
                case 2 -> {
                    switch (arr[i][2]) {
                        case "Niemcy" -> scores[0] += 3;
                        case "Irlandia" -> scores[1] += 3;
                        case "Polska" -> scores[2] += 3;
                        case "Szkocja" -> scores[3] += 3;
                    }
                }
                case 4 -> {
                    if (arr[i][0].equals("Niemcy") || arr[i][2].equals("Niemcy"))
                        scores[0] += 1;
                    if (arr[i][0].equals("Irlandia") || arr[i][2].equals("Irlandia"))
                        scores[1] += 1;
                    if (arr[i][0].equals("Polska") || arr[i][2].equals("Polska"))
                        scores[2] += 1;
                    if (arr[i][0].equals("Szkocja") || arr[i][2].equals("Szkocja"))
                        scores[3] += 1;
                }
            }
        }
        return scores;
    }
}
