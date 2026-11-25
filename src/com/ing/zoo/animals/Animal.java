package com.ing.zoo.animals;

public abstract class Animal {
    public String name;
    public String helloText;
    public String eatText;

    public Animal(String name)
    {
        this.name = name;
    }

    public void sayHello()
    {
        System.out.println(helloText);
    }

    public void eatMeat()
    {
        System.out.println(eatText);
    }

    public String getSayHello()
    {
        return helloText;
    }

    public String getEatText()
    {
        return eatText;
    }
}
