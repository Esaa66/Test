/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragon4;

import java.util.Random;
import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

      

/**
 *
 * @author Ahmad
 */
public class Player {

    
    private String name;
    private String description;
    private int maxlife;
    public int life;
    private int damage;
    private double chance;
    private static Random coincidence = new Random();
    private static boolean sword = false;
    private static boolean havepotion = false;
    private List <Subject> item;
    private Object message;
    
    private  Player(String name, String description, int maxlife, int life,int damage, double chance){
     this.name = name;
     this.description = description;
     this.maxlife = maxlife;
     this.life = life;
     this.damage = damage;
     this.chance = chance;
     item = new ArrayList<>();
    }
    
    private void Heal (Subject potion) {///Reset players health
       this.life +=10;
       item.remove(potion);
    }

    public static boolean sword(){///Svärd
        if (!sword) {
            sword = true;
            return true;
            
        }
        else{
            System.out.println( "You have already picked up the sword");
            return true;
        }
    }
    
    public int defense(Monster monster){
        int incoming_attack = monster.attack();
        int critical_coincidence = coincidence.nextInt(99)+1;
        if (critical_coincidence <= monster.getchance()) {
            incoming_attack *= 2;
            Message.monster();
        }
        Message.playerlife(incoming_attack, monster);
        life =(life > incoming_attack)? life - incoming_attack : 0;
        return life;
    }
    
    public static Player newplayer(){
        return new Player("adventurer","out to find the treasure", 10, 10,1,5);
    }
    
    private String getdescription(){
        return description;
    }
    
    public int getlife(){
        return life;
    }
    
    public boolean alive(){
        if (life > 1){
            return true;
        }
        else {
            return false;
        }
    }
    
    public int getdamage(){
        if (sword){
            return damage +1;
        }
        else {
            return damage;
        }
    }
    
    
    public static boolean havepotion(){
        if (havepotion){
            return true;
        }
        else {
            return false;
        }
    }
    
    public double getchance(){
        return chance;
    }
    
    private List <Subject> getitem(){
        return item;
    }
    
    
    
    

    

        
}
