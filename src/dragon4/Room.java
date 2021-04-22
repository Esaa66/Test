/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragon4;



import static dragon4.Dragon.player.havepotion;
import static dragon4.Player.sword;
import  static dragon4.Player.newplayer;
import dragon4.Monster;

/**
 *
 * @author Ahmad
 */
public class Room {

    private  Monster monster;


    
    private  Monster Monster;
    private static boolean key = false;
    private static boolean treasure = false;
    
    private Room(Monster monster){
        this.Monster =monster;
    }

    
    public Room newroom(){
        return new Room(Monster.newRandommonster());
        
    }
    public void room1(){
        System.out.println("Go to next room\n" + "Press (S) to go south or (R) to go right\n" );
        System.out.println("You find a swor Press (P) to pick upp it");
        String choice = Main.input.nextLine();
        boolean room_status = false;
        do {
            switch (choice){
                case "s":
                    room2();
                    room_status = true;
                case "p":
                    sword();
                    System.out.println("You have a sword now");
                    choice = Main.input.nextLine();
                default:
                    System.out.println("You can inte go in this direction");
                    room1();
                    choice = Main.input.nextLine();
            }
        }while (!room_status);
    }
    
    /**
     *
     */
    public void room2(){
        System.out.println("Gå to next room now\n" + 
                "Press (N) to go north or (S) to go south");
        String choice = Main.input.nextLine();
        boolean room_status = false;
        do {
            switch (choice) {
                case "n":
                    room1();
                    room_status = true;
                case "s":
                    room3();
                    room_status = true;
                default:
                    System.out.println("You can not go in this direction\n" + "Press (N) to go north or (S) to go south");
                    choice = Main.input.nextLine();
                    
            }
        }while (!room_status);
    }
    
    public void room3() {
        System.out.println("Go to next room\n"+ "Press (P) to pick upp the key\n"+ "Press (N) to go north or (R) to go right\n");
        String choice = Main.input.nextLine();
        boolean room_status = false;
        do {
            switch (choice){
                case "n":
                    room2();
                    room_status = true;
                case  "r":
                    room6();
                    room_status = true;
                case "p":
                    key = true;
                    System.out.println("You picked up the key");
                    choice = Main.input.nextLine();
                default:
                    System.out.println("You can not go in this direction");
                    choice = Main.input.nextLine();
            }
        }while (!room_status);
    }
    
    public void room4(){
        System.out.println("You go in to next room and discover a monster");
        System.out.println("Attack!");
        
        Monster.newRandommonster();
        Message.battelintro(Player.newplayer(), Room.newroom());
        Message.battel(newplayer(), Monster.newRandommonster());
        
        System.out.println("The monster dead and come back with another form\n"+ "You will fight a new monster next time\n"+
                "______________________________________\n"+ "Now press (L) to go left or (S) to go south\n"+ "Press (R) to go right to this door beside you");
        String choice = Main.input.nextLine();
        boolean room_status = false;
        do {
            switch (choice){
                case "l":
                    room1();
                    room_status = true;
                case "s":
                    room5();
                    room_status = true;
                case "r":
                    if (!key){
                        System.out.println("The door is closed, looking for the key\n"+ "Press (L) to go left or (s) to go south");
                        choice = Main.input.nextLine();
                        if(key){
                            System.out.println("Oppen the door used the key");
                            if (!treasure){
                                System.out.println("You dicided to escape from the cave without the treasure");
                                System.out.println("Back to main menu");
                                Main.mainmenu();
                                if (treasure);
                                System.out.println("You go out the cave\n"+ "Nice job");
                                System.out.println(
                                "                  _.--.\n"+
                                                    "              _.-'_:-'||\n"+
                                                    "          _.-'_.-::::'||\n"+
                                                    "     _.-:'_.-::::::'  ||\n"+
                                                    "   .'`-.-:::::::'     ||\n"+
                                                    "  /.'`;|:::::::'      ||_\n"+
                                                    " ||   ||::::::'      _.;._'-._\n"+
                                                    " ||   ||:::::'   _.-!oo @.!-._'-.\n"+
                                                    " ||   ||:::::'   _.-!oo @.!-._'-.\n"+
                                                    "   '.'-;|:.-'.&$@.& ()$%-'o.'\\U||\n"+
                                                    "     `>'-.!@%()@'@_%-'_.-o _.|'||\n"+
                                                    "      ||-._'-.@.-'_.-' _.-o  |'||\n"+
                                                    "      ||=[ '-._.-\\U/.-'    o |'||\n"+
                                                    "      || '-.]=|| |'|      o  |'||\n"+
                                                    "      ||      || |'|        _| ';\n"+
                                                    "      ||      || |'|    _.-'_.-'\n"+
                                                    "      |'-._   || |'|_.-'_.-'\n"+
                                                    "      '-._'-.|| |' `_.-'\n"+
                                                    "           '-.||_/.-'\n");
                                System.exit(0);
                            }
                        }
                    }
                default:
                    System.out.println("You can not go in this direction, Press (N) to go north or (S) to go south");
                    choice = Main.input.nextLine();
            }
        }while (!room_status);
    }
    
    public void room5(){
        System.out.println("You go in to next romm");
        if (!havepotion) System.out.println("Press (P) to pick up a potion");
            System.out.println("Press (N) to go north or (S) to go south");
        
            String choice = Main.input.nextLine();
            boolean room_status = false;
            do{
                switch (choice){
                    case "n":
                        room4();
                        room_status = true;
                    case "s":
                        room6();
                        room_status = true;
                    case "p":
                        havepotion = true;
                        System.out.println("You pick up a potion");
                        choice = Main.input.nextLine();
                    default:
                        System.out.println("You can not go in this direction");
                        System.out.println("Press (N) to go north or (S) to go south");
                        choice = Main.input.nextLine();
                        
                }
            }while (!room_status);
    }
    
    public void room6(){
        System.out.println("Go to next room");
        System.out.println("Dragon is in right side!");
        System.out.println("Press (L) to go left, (R)to go right or (N) to go north");
        String choice = Main.input.nextLine();
        boolean room_status = false;
        do{
            switch (choice){
                case "r":
                    room7();
                case "l":
                    room3();
                case "n":
                    room5();
                default:
                    System.out.println("You can not go in this direction");
                    System.out.println("Press (N) to go north, (R) to go right or (L) to go left");
                    choice = Main.input.nextLine();
            }
        }while (!room_status);
    }
    
    public void room7 (){
        System.out.println("Attack!");
        System.out.println("                                                  .~))>>\n"+
                            "                                                 .~)>>\n"+
                            "                                               .~))))>>>\n"+
                            "                                             .~))>>             ___\n"+
                            "                                           .~))>>)))>>      .-~))>>\n"+
                            "                                         .~)))))>>       .-~))>>)>\n"+
                            "                                       .~)))>>))))>>  .-~)>>)>\n"+
                            "                   )                 .~))>>))))>>  .-~)))))>>)>\n"+
                            "                ( )@@*)             //)>))))))  .-~))))>>)>\n"+
                            "              ).@(@@               //))>>))) .-~))>>)))))>>)>\n"+
                            "            (( @.@).              //))))) .-~)>>)))))>>)>\n"+
                            "          ))  )@@*.@@ )          //)>))) //))))))>>))))>>)>\n"+
                            "       ((  ((@@@.@@             |/))))) //)))))>>)))>>)>\n"+
                            "      )) @@*. )@@ )   (\\_(\\-\\b  |))>)) //)))>>)))))))>>)>\n"+
                            "    (( @@@(.@(@ .    _/`-`  ~|b |>))) //)>>)))))))>>)>\n"+
                            "     )* @@@ )@*     (@)  (@) /\\b|))) //))))))>>))))>>\n"+
                            "   (( @. )@( @ .   _/  /    /  \\b)) //))>>)))))>>>_._\n"+
                            "    )@@ (@@*)@@.  (6///6)- / ^  \\b)//))))))>>)))>>   ~~-.\n"+
                            " ( @jgs@@. @@@.*@_ VvvvvV//  ^  \\b/)>>))))>>      _.     `bb\n"+
                            " ((@@ @@@*.(@@ . - | o |' \\ (  ^   \\b)))>>        .'       b`,\n"+
                            "   ((@@).*@@ )@ )   \\^^^/  ((   ^  ~)_        \\  /           b `,\n"+
                            "     (@@. (@@ ).     `-'   (((   ^    `\\ \\ \\ \\ \\|             b  `.\n"+
                            "       (*.@*              / ((((        \\| | |  \\       .       b `.\n"+
                            "                         / / (((((  \\    \\ /  _.-~\\     Y,      b  ;\n"+
                            "                        / / / (((((( \\    \\.-~   _.`\" _.-~`,    b  ;\n"+
                            "                       /   /   `(((((()    )    (((((~      `,  b  ;\n"+
                            "                     _/  _/      `\"\"\"/   /'                  ; b   ;\n"+
                            "                 _.-~_.-~           /  /'                _.'~bb _.'\n"+
                            "               ((((~~              / /'              _.'~bb.--~\n"+
                            "                                  ((((          __.-~bb.-~\n"+
                            "                                              .'  b .~~\n"+
                            "                                              :bb ,' \n"+
                            "                                              ~~~~\n");
        
        Monster.newdragon();
        Message.battelintro(Player.newplayer(), Room.newroom());
        Message.battel(newplayer(), Monster.newdragon());
        
        System.out.println("Dragon is dead, you see the treasure take it!");
        System.out.println("Press (R) to go right");
        treasure = true;
        String choice = Main.input.nextLine();
        boolean room_status = false;
        do{
            switch (choice){
                case "r":
                    room6();
                default:
                    System.out.println("You can not go in this direction");
                    System.out.println("Press (R) to go right");
                    choice = Main.input.nextLine();
            }
        }while (!room_status);
    }
    public Monster getMonster(){
        return monster;}
}
