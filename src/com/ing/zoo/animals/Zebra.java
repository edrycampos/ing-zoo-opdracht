package com.ing.zoo.animals;

import com.ing.zoo.behavior.Herbivore;

public class Zebra extends Animal implements Herbivore {
    public Zebra(String name, String helloText, String eatText)
    {
        super(
                name,
                helloText,
                eatText
        );
    }

    @Override
    public void eatLeaves()
    {
        System.out.println(eatText);
    }

    @Override
    public String getEatLeaves()
    {
        return eatText;
    }
}
