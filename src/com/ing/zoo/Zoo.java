package com.ing.zoo;

import com.ing.zoo.animals.*;
import com.ing.zoo.behavior.Carnivore;
import com.ing.zoo.behavior.Herbivore;
import com.ing.zoo.behavior.TrickPerformer;

import java.util.List;
import java.util.Scanner;

public class Zoo {
    private static final String[] commands = {
            "hello",
            "give leaves",
            "give meat",
            "perform trick"
    };

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
        if(input.equals(commands[0]))
        {
            for (Animal animal: animals)
            {
                animal.sayHello();
            }
        }
        else if (input.equals(commands[1]))
        {
            for (Animal animal: animals)
            {
                if (animal instanceof Herbivore herbivore)
                {
                    herbivore.eatLeaves();
                }
            }
        }
        else if (input.equals(commands[2]))
        {
            for (Animal animal: animals)
            {
                if (animal instanceof Carnivore carnivore)
                {
                    carnivore.eatMeat();
                }
            }
        }
        else if (input.equals(commands[3]))
        {
            for (Animal animal: animals)
            {
                if (animal instanceof TrickPerformer trickPerformer)
                {
                    trickPerformer.performTrick();
                }
            }
        }
        else
        {
            boolean found = false;
            for (Animal animal : animals)
            {
                if (input.equals(commands[0] + " " + animal.getName()))
                {
                    animal.sayHello();
                    found = true;
                    break;
                }
            }
            if (!found)
            {
                System.out.println("Unknown command: " + input);
            }
        }
    }
}
