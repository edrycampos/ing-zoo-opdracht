package com.ing.zoo.animals;

import com.ing.zoo.behavior.Carnivore;

public class Lion extends Animal implements Carnivore {
    public Lion(String name, String helloText, String eatText)
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
}
