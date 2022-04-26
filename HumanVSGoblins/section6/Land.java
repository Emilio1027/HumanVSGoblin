package HumanVSGoblins.section6;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Land {
    int height;
    int width;
    public int humanx;
    public int humany;
    public int goblinx;
    public int gobliny;


    public Land(){
        height=10;
        width =10;
        humanx=ThreadLocalRandom.current().nextInt(0,width);
        humany=ThreadLocalRandom.current().nextInt(0,height);
        goblinx=ThreadLocalRandom.current().nextInt(0,width);
        gobliny=ThreadLocalRandom.current().nextInt(0,height);
    }


    public void moveHuman(int x, int y){
        this.humanx = x;
        this.humany = y;

    }
    public void moveGoblin(int x, int y){
        this.goblinx = x;
        this.gobliny = y;

    }

    public boolean humanOverlapGoblin(){

        return humanx==goblinx && humany==gobliny;
    }
    public void drawMap(Human human, Goblin goblin){
        for (int i = 0 ; i< height;i++){
            for (int j = 0; j<width; j++){

                if (j==humanx && i==humany){
                    System.out.print(human);

                }
                else if (j==goblinx && i==gobliny){
                    System.out.print(goblin);
                }
                    else {
                    System.out.print(this);
                }
            }
            System.out.println();
        }

    }


    @Override
    public String toString() {

        return "\u26FA";
    }
}
