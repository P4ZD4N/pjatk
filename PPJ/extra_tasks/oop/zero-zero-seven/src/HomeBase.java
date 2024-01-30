import java.util.Arrays;

public class HomeBase {
    private Secret[] gatheredSecrets = new Secret[0];
    private Agent[] agentsWhichSoldSecrets = new Agent[0];

    public void buySecret(Agent agent) {
        if (agent.getSecret() != null && agent.isActive()) {

            int randomNumber = (int) (Math.random() * 10);
            if (randomNumber > 2) {
                addElementToArray(gatheredSecrets, agent.getSecret());
                addElementToArray(agentsWhichSoldSecrets, agent);

                System.out.println("Bought and added secret to gathered secrets: " + agent.getSecret().getName());
            } else
                System.out.println("Connection with server was interrupted. Secret was lost!");

            agent.setMoney(agent.getMoney() + agent.getSecret().getValue());
            System.out.println("Paid " + agent.getSecret().getValue() + " money to agent");

            agent.setSecret(null);

        } else if (agent.getSecret() == null && agent.isActive())
            System.out.println("This agent don't have any secret at this moment!");
        else if (agent.getSecret() != null && !agent.isActive() || agent.getSecret() == null && !agent.isActive())
            System.out.println("Agent is not active at this moment!");

    }

    private <T> void addElementToArray(T[] array, T element) {
        T[] arrayWithNewElement = Arrays.copyOf(array, array.length + 1);
        arrayWithNewElement[array.length] = element;

        if (array instanceof Secret[])
            gatheredSecrets = (Secret[]) arrayWithNewElement;
        else if (array instanceof Agent[])
            agentsWhichSoldSecrets = (Agent[]) arrayWithNewElement;
    }

    public void showSecrets() {
        for (int i = 0; i < agentsWhichSoldSecrets.length || i < gatheredSecrets.length; i++)
            System.out.println(gatheredSecrets[i] + " delivered by " + agentsWhichSoldSecrets[i]);
    }
}
