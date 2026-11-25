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
                "zebra zebra",
                "grrumph",
                "arf arf"
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
                "nomnomnom oink wubalubadubdub",
                "krrrrrrrrrrrr",
                "eek eek"
        );

        Zoo.handleCommand(input, animals);

        assertEquals(expected, output.toString().trim());
    }

    @Test
    void testPerformTrick()
    {
        input = "perform trick";
        List<String> expectedPig = List.of(
                "dora: rolls in the mud",
                "dora: runs in circles"
        );
        List<String> expectedTiger = List.of(
                "wally: jumps in tree",
                "wally: scratches ears"
        );
        List<String> expectedPlatypus = List.of(
                "perry: puts hat on",
                "perry: goes for a swim"
        );
        List<String> expectedSeal = List.of(
                "finn: balances ball",
                "finn: claps flippers"
        );

        Zoo.handleCommand(input, animals);

        String[] actual = output.toString().trim().split("\\R");

        assertEquals(4, actual.length);
        assertTrue(expectedPig.contains(actual[0]));
        assertTrue(expectedTiger.contains(actual[1]));
        assertTrue(expectedPlatypus.contains(actual[2]));
        assertTrue(expectedSeal.contains(actual[3]));
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
