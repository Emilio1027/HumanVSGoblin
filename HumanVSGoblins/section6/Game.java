package HumanVSGoblins.section6;

import java.util.Scanner;

public class Game  {
    /**
     *  1. Everything must be objects: land/goblins/humans
     *  2. You must override the toString() method to represent each of the objects
     *  3. Create a grid for the game world
     *  4. Use UTF characters for the players and goblins and the land
     *  5. Game is turn based move n/s/e/w
     *  6. Once a human and goblin collide combat is initiated
     *  7. Combat uses math.random
     *  8. Extras:
     *      a:Human has inventory system
     *      b:Goblins have drops
     *      c:Stats can be modified by equipment
     *      d:Map gen random treasure chest after each round of combat
     *      e:Goblins pursue player
     */
    Scanner keyboard;
    Human human;
    Goblin goblin;
    Land land;


    public Game(){
        human = new Human();
        goblin = new Goblin();
        land = new Land();
        land.drawMap(human,goblin);
        keyboard = new Scanner(System.in);
    }

    public static void main(String[] args) {

       Game game = new Game();
       while (!game.land.humanOverlapGoblin()){
           game.playerInput();
        game.land.drawMap(game.human,game.goblin);
       }
        if (game.human.attack().equals("human")){
            System.out.println("Human wins");
        }else{
            System.out.println("Goblins wins");
        }

    }
    public void playerInput(){
        System.out.println("Where do you want to go (n/s/e/w) ");
       String togo =keyboard.next();
       if (togo == null || togo.isEmpty()){
           playerInput();
           return;
       }
        togo = togo.toLowerCase().substring(0,1);

       switch (togo){
           case "n": land.moveHuman(land.humanx,land.humany-1);
           break;
           case "s": land.moveHuman(land.humanx,land.humany+1);
               break;
           case "e": land.moveHuman(land.humanx +1,land.humany);
               break;
           case "w": land.moveHuman(land.humanx-1,land.humany);
               break;
           default: land.moveHuman(land.humanx,land.humany);
       }

    }
}

