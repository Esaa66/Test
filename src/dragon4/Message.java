/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragon4;


import static dragon4.Dragon.player;


/**
 *
 * @author Ahmad
 */
public class Message {
    
    
    public static void damage() {
        System.out.println( "You do double damage to enemy ");
    }
    
    
    public static void monster() {// Visa upp ett meddelande
        System.out.println( "The monster does double damage to you");
    }
    public static void Wellcome(){ // Visa upp ett meddelande
        System.out.println("Wellcome to our examination assignment");
        System.out.println("Please choise one of the following!");
        System.out.println("1. New game \n" + "2. Finish");
        System.out.println();
        System.out.println();
    }
    
    
    public static void newgame(){// Visa upp ett meddelande
        System.out.println(" Press Y for att continue, Press N for go back");
    }
    
    public static boolean playerstatic(String name, String descreption, int Maxlife, int damage, double chance) {
        System.out.println();
        System.out.println(name);
        System.out.println();
        System.out.println(descreption);
        System.out.println();
        System.out.println("Maxlife" + Maxlife);
        System.out.println("Damage" + damage);
        System.out.println("You have" + chance +"to do double damage");
        System.out.println("Redy?");
        System.out.println("J/N");
        System.out.println();
        if (Main.input.nextLine().equals("y")){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void battelintro(Player player, Room room){
        System.out.println("You start your battel" + room.getMonster().getname());
    }
    
    public void battel(Player player, Monster monster){
        while (player.alive() && monster.die()){
            System.out.println("Monster health" + monster.getlife()+ "    " + "Player health" + player.getlife());
            System.out.println("-----------");
            System.out.println("Press(A)to attack\n Press(R)to reset a life");
            String action = Main.input.nextLine();
            if (action.equals("a")){
                monster.protaction(player);
                
                if(monster.die())
                    player.defense(monster);
                if(action.equals("r")){
                    player.havepotion();
                    if(Dragon.player.havepotion = true) {
                        player.life = 10;
                        System.out.println("Drink a potion to reset your health");
                        Dragon.player.havepotion = false; //Can not take more potions
                        player.defense(monster);
                    }
                    else {
                        System.out.println("You don`t have any potion");
                    }
                }
            }
            if(!player.alive()){
                System.out.println("Game over!");
                Main.mainmenu();
                 if (!monster.die()){
                        System.out.println("Monster has died");
                        System.out.println("---------");
                        }    
            }
        }
    }

    
    public static void monsterlife(int damage, Monster monster){
        System.out.println("You hit" + Monster.newRandommonster()+ damage);
    }

    public static void playerlife(int damage, Monster monster) {
        System.out.println(Monster.newRandommonster()+ "Hit you" + damage); //To change body of generated methods, choose Tools | Templates.
    }

    

    

   
}
