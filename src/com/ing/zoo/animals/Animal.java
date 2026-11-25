package com.ing.zoo.animals;

public abstract class Animal {
    private final String name;
    private final String helloText;
    public String eatText;

    public Animal(String name, String helloText, String eatText)
    {
        this.name = name;
        this.helloText = helloText;
        this.eatText = eatText;
    }

    public void sayHello()
    {
        System.out.println(helloText);
    }

    public String getSayHello()
    {
        return helloText;
    }

    public String getName()
    {
        return name;
    }
}
