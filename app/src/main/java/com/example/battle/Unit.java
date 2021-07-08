package com.example.battle;

import android.util.Log;

public class Unit {
    private int health;
    private int attack;
    private String name;


    public Unit (Integer health, Integer attack, String name){
        this.health = health;
        this.attack = attack;
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int randomIndex (int i) {
        int random =(int) ((Math.random() * (5 - i)) + i);
        Log.d("MyLog", "random index is "+String.valueOf(random));
        return random;
    }

    public int totalScore (int redhealh, int redattack, int greenhealh, int greenattack){
        int score = redhealh/greenattack-greenhealh/redattack;
        return score;
    }

    public String battle (int redhealh, int redattack, String redname, int greenhealh, int greenattack, String greenname){
        int score = redhealh/greenattack-greenhealh/redattack;
        Log.d("MyLog", " score of battle is " + String.valueOf(score));
        if (score<0) {
            Log.d("MyLog", greenname + " won");
            String name = greenname;
            return name;
        }
        if (score==0) {
            Log.d("MyLog", greenname + " " + redname + " fell");
            String name ="dead heat";
            return name;
        }
        if (score>0){
            Log.d("MyLog", redname + " won");
            String name = redname;
            return name;
        }
          return "The bout over";
    }
    public int checkIndex (int random,int i){
         int index = random;
         if (index!=i) index = i;
        return  index;
    }
}


