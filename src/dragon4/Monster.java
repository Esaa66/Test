/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragon4;

import java.util.Random;


/**
 *
 * @author Ahmad
 */
public class Monster {

    

   


    
    private String name;
    private String description;
    private int maxlife;
    private int life;
    private int damage;
    private double chance;
    private static Random coincidence = new Random();
    private Object player;
    
    private Monster(String name, String description, int maxlife, int life, int damage, double chance){
        this.name = name;
        this.description = description;
        this.maxlife = maxlife;
        this.life = life;
        this.damage = damage;
        this.chance = chance;
    }

    

    

    
    public int attack (){
        return damage;
    }
    
    public int protaction(Player player){
        int incoming_attack = player.getdamage();
        int critical_coincidence = coincidence.nextInt(99) + 1;
        if(critical_coincidence <= player.getchance()){
            incoming_attack *= 2;
            Message.damage();
            return incoming_attack;
        }
        
        Message.monsterlife(incoming_attack, this);
        life =(life > incoming_attack) ? life - incoming_attack : 0;
        return life;
        }
    
    public static Monster newRandommonster(){
    int random = coincidence.nextInt(2);
    Monster monster;
    monster = null;
    switch (random){
        case 1:
            monster = newSpider();
            break;
        case 2:
            monster = newSkeleton();
            break;
    }
    return monster;
    }
    
public static Monster newSpider(){
    return new Monster("Spider", "Kill it!",8,8,1,3);
}

public static Monster newSkeleton(){
    return new Monster("Skeleton","Kill it!",8, 8, 1, 8);
}
public Monster newdragon(){
    return new Monster ("Dragon", "Kill it!", 18,18,1,5);
}

public String getdescription(){
    return description;
}

public int getlife(){
    return life;
}

//public boolean die(){
     //   if (life<1){
      //     return true;
      //  }
      //  else{
      //      return false;
      //  }
  //  }

public boolean die(){
    return life > 0;
}

public double getchance(){
    return chance;
}

public String getname(){
    return name;
}

        

        

        

        

        
    }

    

