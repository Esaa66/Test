/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragon4;

import dragon4.Room;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Ahmad
 */
public class Main {
    public static Scanner input = new Scanner(System.in);
    public static Random coincidence = new Random();
    public static Player currentplayer;
    
    public static void main(String[] args) {
        mainmenu();
    }

    public static void mainmenu() {
        boolean status = false;
        do{
         Message.Wellcome();
         String choice = input.nextLine();
         switch (choice){
             case "1":
                 Newgame();
                 status =true;
                 break;
             case "2":
                 System.exit(0);
        }
        } while (!status);
        
    }

    

    public static void Newgame() {
       boolean status = false;
       do {
           Message.newgame();
           String choice = input.nextLine();
           switch (choice){
               case "y":
                   Message.playerstatic("Adventurer", "looking for the treasure", 10,1,10);
                   currentplayer = Player.newplayer();
                   entry();
                   break;
               case "n":    
                   Main.mainmenu();
                   break;
       }
       } while (!status); }

    public static void entry() {
        System.out.print("We hear about a treasure in the cave, if you want to enter the cave push (H)");
        String choice = input.nextLine();
        switch (choice){
            case "h":
                Room.room2();
            default:
                System.out.println("You kan enter the cave by pressing (H)");
        }
    }
        



    
}
