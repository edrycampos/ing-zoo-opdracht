package test.java;

import com.ing.zoo.Zoo;
import com.ing.zoo.animals.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ZooTest {
    private ByteArrayOutputStream output;
    private PrintStream originalOut;
    private final List<Animal> animals = Zoo.getAnimals();
    private String input;

    @BeforeEach
    void setUp()
    {
        originalOut = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown()
    {
        System.setOut(originalOut);
    }

    @Test
    void testAllAnimalsSayHello()
    {
        input = "hello";
        String expected = String.join(
                System.lineSeparator(),
                "roooaoaaaaar",
                "splash",
                "splash",
                "rraaarww",
                "zebra zebra"
        );

        Zoo.handleCommand(input, animals);

        assertEquals(expected, output.toString().trim());
    }

    @Test
    void testHenkSaysHello()
    {
        input = "hello henk";
        String expected = "roooaoaaaaar";

        Zoo.handleCommand(input, animals);

        assertEquals(expected, output.toString().trim());
    }

    @Test
    void testGiveLeaves()
    {
        input = "give leaves";
        String expected = String.join(
                System.lineSeparator(),
                "munch munch lovely",
                "munch munch lovely",
                "munch munch zank yee bra"
        );

        Zoo.handleCommand(input, animals);

        assertEquals(expected, output.toString().trim());
    }

    @Test
    void testGiveMeat()
    {
        input = "give meat";
        String expected = String.join(
                System.lineSeparator(),
                "nomnomnom thx mate",
                "nomnomnom oink thx",
                "nomnomnom oink wubalubadubdub"
        );

        Zoo.handleCommand(input, animals);

        assertEquals(expected, output.toString().trim());
    }

    @Test
    void testPerformTrick()
    {
        input = "perform trick";
        List<String> expected = List.of(
                "jumps in tree",
                "scratches ears",
                "rolls in the mud",
                "runs in circles"
        );

        Zoo.handleCommand(input, animals);

        String[] actual = output.toString().trim().split("\\R");

        assertEquals(2, actual.length);
        for (String line : actual)
        {
            assertTrue(expected.contains(line));
        }
    }

    @Test
    void testUnknownCommand()
    {
        input = "unknown command";
        String expected = "Unknown command: " + input;

        Zoo.handleCommand(input, animals);

        assertEquals(expected, output.toString().trim());
    }
}
