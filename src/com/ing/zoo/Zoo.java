package com.ing.zoo;

import com.ing.zoo.animals.*;
import com.ing.zoo.behavior.Carnivore;
import com.ing.zoo.behavior.Herbivore;
import com.ing.zoo.behavior.TrickPerformer;

import java.util.List;
import java.util.Scanner;

public class Zoo {
    private static final String HELLO = "hello";
    private static final String GIVE_LEAVES = "give leaves";
    private static final String GIVE_MEAT = "give meat";
    private static final String PERFORM_TRICK = "perform trick";

    public static void main(String[] args)
    {
        List<Animal> animals = getAnimals();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Voer uw command in: ");

        String input = scanner.nextLine();
        handleCommand(input, animals);
    }

    public static List<Animal> getAnimals() {
        Lion henk = new Lion(
                "henk",
                "roooaoaaaaar",
                "nomnomnom thx mate"
        );
        Hippo elsa = new Hippo(
                "elsa",
                "splash",
                "munch munch lovely"
        );
        Pig dora = new Pig(
                "dora",
                "splash",
                "munch munch lovely",
                "nomnomnom oink thx"
        );
        Tiger wally = new Tiger(
                "wally",
                "rraaarww",
                "nomnomnom oink wubalubadubdub"
        );
        Zebra marty = new Zebra(
                "marty",
                "zebra zebra",
                "munch munch zank yee bra"
        );

        return List.of(henk, elsa, dora, wally, marty);
    }

    public static void handleCommand(String input, List<Animal> animals)
    {
        switch (input)
        {
            case HELLO -> greetAnimals(animals);
            case GIVE_LEAVES -> feedHerbivores(animals);
            case GIVE_MEAT -> feedCarnivores(animals);
            case PERFORM_TRICK -> performTricks(animals);
            default -> greetSpecificAnimal(input, animals);
        }
    }

    private static void greetAnimals(List<Animal> animals)
    {
        for (Animal animal: animals)
        {
            animal.sayHello();
        }
    }

    private static void greetSpecificAnimal(String input, List<Animal> animals)
    {
        for (Animal animal : animals)
        {
            if (input.equals(HELLO + " " + animal.getName()))
            {
                animal.sayHello();
                return;
            }
        }

        System.out.println("Unknown command: " + input);
    }

    private static void feedCarnivores(List<Animal> animals)
    {
        for (Animal animal: animals)
        {
            if (animal instanceof Carnivore carnivore)
            {
                carnivore.eatMeat();
            }
        }
    }

    private static void feedHerbivores(List<Animal> animals)
    {
        for (Animal animal: animals)
        {
            if (animal instanceof Herbivore herbivore)
            {
                herbivore.eatLeaves();
            }
        }
    }

    private static void performTricks(List<Animal> animals)
    {
        for (Animal animal: animals)
        {
            if (animal instanceof TrickPerformer trickPerformer)
            {
                trickPerformer.performTrick();
            }
        }
    }
}
