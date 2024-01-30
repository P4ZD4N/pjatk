public class EnemyHideout {
    private static int nextId = 1;
    private int id;
    private String name;
    private Secret secret;
    private String[] requiredSkills;

    public EnemyHideout(String name, Secret secret, String[] requiredSkills) {
        id = nextId++;
        this.name = name;
        this.secret = secret;
        this.requiredSkills = requiredSkills;
    }

    public Secret getSecret() {
        return secret;
    }

    public void setSecret(Secret secret) {
        this.secret = secret;
    }

    public String[] getRequiredSkills() {
        return requiredSkills;
    }
}
