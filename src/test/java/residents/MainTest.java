package residents;

import org.junit.jupiter.api.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testFindManOk1() throws Exception {
        List<Resident>actualList=List.of(new Resident(25,1),  new Resident(70,1),
                                           new Resident(100, 0),new Resident(3, 1));
        Assertions.assertEquals(2, Main.findMan(actualList));
    }

    @Test
    void testFindManOk2() throws Exception {
        List<Resident>actualList=List.of(new Resident(25,0), new Resident(25,1));
        Assertions.assertEquals(2, Main.findMan(actualList));
    }

    @Test
    void testFindManOk3() throws Exception {
        List<Resident>actualList=List.of(new Resident(25,1), new Resident(42,0), new Resident(25,1));
        Assertions.assertEquals(1, Main.findMan(actualList));
    }

    @Test
    void testFindManNok1() throws Exception {
        List<Resident>actualList=List.of(new Resident(25,0), new Resident(2,0), new Resident(19,0));
        Assertions.assertEquals(-1, Main.findMan(actualList));
    }
}