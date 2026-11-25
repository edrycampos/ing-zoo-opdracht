package com.ing.zoo.animals;

import com.ing.zoo.behavior.Carnivore;
import com.ing.zoo.behavior.Herbivore;
import com.ing.zoo.behavior.TrickPerformer;

import java.util.Random;

public class Pig extends Animal implements Carnivore, Herbivore, TrickPerformer {
    public String trick;
    public String eatMeatText;

    public Pig(String name, String helloText, String eatText, String eatMeatText)
    {
        super(
                name,
                helloText,
                eatText
        );
        this.eatMeatText = eatMeatText;
    }

    @Override
    public void eatLeaves()
    {
        System.out.println(eatText);
    }

    @Override
    public void eatMeat()
    {
        System.out.println(eatMeatText);
    }

    @Override
    public void performTrick()
    {
        Random random = new Random();
        int rnd = random.nextInt(2);
        if(rnd == 0)
        {
            this.trick = "rolls in the mud";
        }
        else
        {
            this.trick = "runs in circles";
        }
        System.out.println(this.trick);
    }

    @Override
    public String getEatLeaves()
    {
        return eatText;
    }

    @Override
    public String getEatMeat()
    {
        return eatMeatText;
    }

    @Override
    public String getTrick()
    {
        return this.trick;
    }
}
