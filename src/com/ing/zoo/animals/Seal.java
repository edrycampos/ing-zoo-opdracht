package com.ing.zoo.animals;

import com.ing.zoo.behavior.Carnivore;
import com.ing.zoo.behavior.TrickPerformer;

import java.util.Random;

public class Seal extends Animal implements Carnivore, TrickPerformer {
    private String trick;

    public Seal(
            String name,
            String helloText,
            String eatText
    )
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
    public void performTrick()
    {
        Random random = new Random();
        int rnd = random.nextInt(2);
        if(rnd == 0)
        {
            this.trick = "balances ball";
        }
        else
        {
            this.trick = "claps flippers";
        }
        System.out.println(this.trick);
    }

    @Override
    public String getEatMeat()
    {
        return eatText;
    }

    @Override
    public String getTrick()
    {
        return this.trick;
    }
}
