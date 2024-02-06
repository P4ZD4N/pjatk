package tasks;

public class SpamFilter {
    private String[] info;
    private String[] keywords;

    public SpamFilter(String[] info, String[] keywords) {
        this.info = info;
        this.keywords = keywords;
    }

    public String[] getInfo() {
        return info;
    }

    public void run() {
        for (int i = 0; i < info.length; i++)
            for (String keywordsElement : keywords)
                if (info[i].equals(keywordsElement))
                    info[i] = "Blocked";
        System.out.println("Spam filtered!");
    }
}
