package test.java;

import com.ing.zoo.animals.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    public String helloText;
    public String eatText;
    public String eatMeatText;

    @Test
    void testLionSayHello() {
        helloText = "roooaoaaaaar";
        eatText = "nomnomnom thx mate";
        Lion lion = new Lion(
                "lion",
                helloText,
                eatText
        );

        assertEquals(helloText, lion.getSayHello());
    }

    @Test
    void testLionEatMeat() {
        helloText = "roooaoaaaaar";
        eatText = "nomnomnom thx mate";
        Lion lion = new Lion(
                "lion",
                helloText,
                eatText
        );

        assertEquals(eatText, lion.eatText);
    }

    @Test
    void testHippoEatLeaves() {
        helloText = "splash";
        eatText = "munch munch lovely";

        Hippo hippo = new Hippo(
                "hippo",
                helloText,
                eatText
        );

        assertEquals(eatText, hippo.getEatLeaves());
    }

    @Test
    void testPigEat()
    {
        helloText = "splash";
        eatText = "munch munch lovely";
        eatMeatText = "nomnomnom oink thx";
        Pig pig = new Pig(
                "pig",
                helloText,
                eatText,
                eatMeatText
        );

        // Testing eatLeaves first
        assertEquals(eatText, pig.getEatLeaves());

        // Testing eatMeat second
        assertEquals(eatMeatText, pig.getEatMeat());
    }

    @Test
    void testTigerTrick()
    {
        helloText = "rraaarww";
        eatText = "nomnomnom oink wubalubadubdub";

        Tiger tiger = new Tiger(
                "tiger",
                helloText,
                eatText
        );

        tiger.performTrick();
        assertTrue(
                tiger.getTrick().equals("jumps in tree") ||
                        tiger.getTrick().equals("scratches ears")
        );
    }
}