package HumanVSGoblins.section6;

import java.util.concurrent.ThreadLocalRandom;

public class Human {


    public Human() {

    }

    @Override
    public String toString() {

        return "\u26F9";
    }

    public String attack(){

        return ThreadLocalRandom.current().nextInt(2)==0? "human":"goblin";
    }
}
