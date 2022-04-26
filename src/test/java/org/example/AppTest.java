package org.example;
import HumanVSGoblins.section6.Land;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;




public class AppTest {
    Land land;

    @BeforeEach
    public void setUp() {
        land = new Land();
    }


    @Test
    public void moveHumanTest() {
        List<Integer> numbers = (List<Integer>) IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList());
        for (int value : numbers) {
            land.moveHuman(value, value);
            assertEquals(value, land.humanx);
            assertEquals(value, land.humany);
        }
    }

    @Test
    public void moveGoblinTest() {
        List<Integer> numbers = (List<Integer>) IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList());
        for (int value : numbers) {
            land.moveGoblin(value, value);
            assertEquals(value, land.goblinx);
            assertEquals(value, land.gobliny);
        }
    }
    @Test
    public void overLapTest(){
        land.moveHuman(5,7);
        land.moveGoblin(3,23);
        assertFalse(land.humanOverlapGoblin());
        land.moveHuman(5,7);
        land.moveGoblin(5,7);
        assertTrue(land.humanOverlapGoblin());
    }
}

