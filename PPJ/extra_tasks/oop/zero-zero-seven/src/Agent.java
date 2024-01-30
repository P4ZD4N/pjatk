import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Agent {
    private static int nextId = 1;
    private int id;
    private String name;
    private String codename;
    private String[] previousCodenames = new String[0];
    private boolean isActive = true;
    private String[] skills = new String[6];
    private Secret secret;
    private double money;

    public Agent(String name, String codename, double money) {
        id = nextId++;
        this.name = name;
        this.codename = codename;
        this.money = money;
    }

    private void updatePreviousCodenames() {
        if (isActive) {
            String[] previousCodenamesWithNewCodename = new String[previousCodenames.length + 1];

            for (int i = 0; i < previousCodenames.length; i++)
                previousCodenamesWithNewCodename[i] = previousCodenames[i];

            previousCodenamesWithNewCodename[previousCodenames.length] = this.codename;

            previousCodenames = previousCodenamesWithNewCodename;
        } else
            System.out.println("Agent is not active at this moment!");
    }

    public void changeCodename(String codename) {
        if (isActive) {
            for (String previousCodename : previousCodenames) {
                if (previousCodename.equals(codename)) {
                    System.out.println("This codename was used earlier!");
                    return;
                }
            }

            System.out.println("Codename successfully changed from " + this.codename + " to " + codename);

            updatePreviousCodenames();

            this.codename = codename;
        } else
            System.out.println("Agent is not active at this moment!");
    }

    public void addSkill(String skill) {
        if (isActive) {
            for (int i = 0; i < skills.length; i++) {
                if (skills[i] == null) {
                    skills[i] = skill;
                    System.out.println(skill + " added to skills!");
                    return;
                } else if (i == skills.length - 1 && skills[i] != null) {
                    String deletedSkill = skills[0];
                    String[] skillsWithNewSkill = new String[6];

                    int indexToInsert = 0;
                    for (int j = 1; j < skills.length; j++)
                        skillsWithNewSkill[indexToInsert++] = skills[j];
                    skillsWithNewSkill[indexToInsert] = skill;

                    skills = skillsWithNewSkill;
                    System.out.println("Deleted skill: " + deletedSkill + " and added new: " + skill);
                }
            }
        } else
            System.out.println("Agent is not active at this moment!");
    }

    public void stealSecret(EnemyHideout enemyHideout) {
        if (isActive) {
            if (isAgentCapableToStealSecretFrom(enemyHideout)) {

                int randomNumber = (int) (Math.random() * 10);
                if (randomNumber > 3) {
                    secret = enemyHideout.getSecret();
                    enemyHideout.setSecret(null);
                    System.out.println("Agent have new secret!: " + secret.getName());
                } else {
                    System.out.println("Agent was caught on stealing secret!");
                    isActive = false;
                    System.out.println("Since this moment agent is not active. You must force him to work!");
                }
            } else
                System.out.println("Agent don't have enough skills to steal secret from this hideout!");
        } else
            System.out.println("Agent is not active at this moment!");
    }

    private boolean isAgentCapableToStealSecretFrom(EnemyHideout enemyHideout) {
        Set<String> requiredSkills = new HashSet<>(Arrays.asList(enemyHideout.getRequiredSkills()));
        Set<String> ownedSkills = new HashSet<>(Arrays.asList(skills));

        int requiredSkillsWhichAgentHas = 0;
        for (String requiredSkill : requiredSkills)
            for (String ownedSkill : ownedSkills)
                if (requiredSkill.equalsIgnoreCase(ownedSkill))
                    requiredSkillsWhichAgentHas++;

        return requiredSkills.size() == requiredSkillsWhichAgentHas;
    }

    public void receiveMoneyTransfer(double money) {
        if (isActive) {
            System.out.println("Agent received money transfer! +" + money);
            this.money += money;
        } else
            System.out.println("Agent is not active at this moment!");
    }

    public int getId() {
        return id;
    }

    public String getCodename() {
        return codename;
    }

    public String[] getPreviousCodenames() {
        return previousCodenames;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive() {
        isActive = true;
        System.out.println("Agent is active from now!");
    }

    public Secret getSecret() {
        return secret;
    }

    public void setSecret(Secret secret) {
        this.secret = secret;
    }

    public String[] getSkills() {
        return skills;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", codename='" + codename + '\'' +
                ", previousCodenames=" + Arrays.toString(previousCodenames) +
                ", isActive=" + isActive +
                ", skills=" + Arrays.toString(skills) +
                ", secret=" + secret +
                ", money=" + money +
                '}';
    }
}
