package com.ing.zoo.animals;

import com.ing.zoo.behavior.Carnivore;
import com.ing.zoo.behavior.TrickPerformer;

import java.util.Random;

public class Tiger extends Animal implements Carnivore, TrickPerformer {
    private String trick;

    public Tiger(String name, String helloText, String eatText)
    {
        super(
                name,
                helloText,
                eatText
        );
    }

    @Override
    public void eatMeat()
    {
        System.out.println(eatText);
    }

    @Override
    public String getEatMeat()
    {
        return eatText;
    }

    @Override
    public void performTrick()
    {
        Random random = new Random();
        int rnd = random.nextInt(2);
        if(rnd == 0)
        {
            this.trick = "jumps in tree";
        }
        else
        {
            this.trick = "scratches ears";
        }
        System.out.println(this.trick);
    }

    @Override
    public String getTrick()
    {
        return this.trick;
    }
}
