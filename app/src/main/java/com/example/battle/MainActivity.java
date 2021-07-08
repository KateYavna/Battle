package com.example.battle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Object squire = new Unit(0, 0, "squire");
        Unit redLightSwordsman = new Unit(70, 10, "redLightSwordsman");
        Unit redHeavySwordsman = new Unit(100, 15, "redHeavySwordsman");
        Unit redSpearman = new Unit(170, 20, "redSpearman");
        Unit redKnight = new Unit(200, 35, "redKnight");
        Unit redGeneral = new Unit(300, 20, "redGeneral");

        Unit greenLightSwordsman = new Unit(70, 10, "greenLightSwordsman");
        Unit greenHeavySwordsman = new Unit(100, 15, "greenHeavySwordsman");
        Unit greenSpearman = new Unit(170, 20, "greenSpearman");
        Unit greenKnight = new Unit(200, 35, "greenKnight");
        Unit greenGeneral = new Unit(300, 20, "greenGeneral");

        ArrayList redUnits = new ArrayList(5);
        redUnits.add(redLightSwordsman);
        redUnits.add(redHeavySwordsman);
        redUnits.add(redSpearman);
        redUnits.add(redKnight);
        redUnits.add(redGeneral);

        ArrayList<String> wonRedUnits = new ArrayList();

        ArrayList greenUnits = new ArrayList(5);
        greenUnits.add(greenLightSwordsman);
        greenUnits.add(greenHeavySwordsman);
        greenUnits.add(greenSpearman);
        greenUnits.add(greenKnight);
        greenUnits.add(greenGeneral);

        ArrayList<String> wonGreenUnits = new ArrayList();

        int i = 0;
        int totalScore = 0;
        while (i < 5) {
            int redrandom = ((Unit) squire).randomIndex(i);
            int redattack = ((Unit) redUnits.get(redrandom)).getAttack();
            int redhealth = ((Unit) redUnits.get(redrandom)).getHealth();
            String redname = ((Unit) redUnits.get(redrandom)).getName();


            int greenrandom = ((Unit) squire).randomIndex(i);
            int greenattack = ((Unit) greenUnits.get(greenrandom)).getAttack();
            int greenhealth = ((Unit) greenUnits.get(greenrandom)).getHealth();
            String greenname = ((Unit) greenUnits.get(greenrandom)).getName();

            String name = ((Unit) squire).battle(redhealth, redattack, redname, greenhealth, greenattack, greenname);
            totalScore = totalScore + ((Unit) squire).totalScore(redhealth, redattack, greenhealth, greenattack);

            if (name.equals(greenname)) wonGreenUnits.add(greenname);
            if (name.equals(redname)) wonRedUnits.add(redname);
            int redindex = ((Unit) redUnits.get(redrandom)).checkIndex(redrandom, i);
            redUnits.add(redindex, ((Unit) redUnits.get(redrandom)));
            redUnits.remove(redrandom + 1);

            int greenindex = ((Unit) greenUnits.get(greenrandom)).checkIndex(greenrandom, i);
            greenUnits.add(greenindex, ((Unit) greenUnits.get(greenrandom)));
            greenUnits.remove(greenrandom + 1);

            i = i + 1;

        }
        int sizeWonGreenUnits = wonGreenUnits.size();
        int sizeWonRedUnits = wonRedUnits.size();
        Log.d("MyLog", " reds " + sizeWonRedUnits);
        Log.d("MyLog", " greens " + sizeWonGreenUnits);
        if (sizeWonGreenUnits > sizeWonRedUnits) {
            Log.d("MyLog", "green team won ");
            Log.d("MyLog", "green team winners: " + wonGreenUnits.get(0));
            Log.d("MyLog", wonGreenUnits.get(1));
            Log.d("MyLog", wonGreenUnits.get(2));
        }
        if (sizeWonGreenUnits < sizeWonRedUnits) {
            Log.d("MyLog", "red team won ");
            Log.d("MyLog", "red team winners: " + wonRedUnits.get(0));
            Log.d("MyLog", wonRedUnits.get(1));
            Log.d("MyLog", wonRedUnits.get(2));

        }
        if (sizeWonGreenUnits == sizeWonRedUnits) {
            if (totalScore==0) Log.d("MyLog", " Nobody won ");
            if (totalScore < 0) Log.d("MyLog", " Victory on points is awarded to green ");
            if (totalScore > 0) Log.d("MyLog", " Victory on points is awarded to red ");
        }

        WaterUnit fishingBoat = new WaterUnit(700,100,"fishingBoat");
        WaterUnit corvette = new WaterUnit(1000,150, "corvette");
        WaterUnit frigate = new WaterUnit(1700,200,"frigate");
        WaterUnit battleship = new WaterUnit(2000,200,"battleship");

    }

}