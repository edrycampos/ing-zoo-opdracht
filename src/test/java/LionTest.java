package test.java;

import com.ing.zoo.animals.Animal;
import com.ing.zoo.animals.Lion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    public String helloText;
    public String eatText;

    @Test
    void testLionSayHello() {
        Animal henk = new Lion("henk");
        helloText = "roooaoaaaaar";

        assertEquals(helloText, henk.getSayHello());
    }

    @Test
    void testLionEatMeat() {
        Animal henk = new Lion("henk");
        eatText = "nomnomnom thx mate";

        assertEquals(eatText, henk.getEatText());
    }
}