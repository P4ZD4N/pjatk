package squad;

import exception.TooManyHeroesException;

public class Squad {

    private String name;
    private Leader leader;
    private Hero[] heroes = new Hero[1];

    public Squad(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    public Hero[] getHeroes() {
        return heroes;
    }

    public void setHeroes(Hero[] heroes) {
        this.heroes = heroes;
    }

    public void addHero(Hero hero) {
        if (heroes[0] == null) {
            heroes[0] = hero;
        } else
            throw new TooManyHeroesException();
    }

    @Override
    public String toString() {
        return name + ", leader: " + leader.getName() + ", heroes: " + heroes[0].getName();
    }
}
